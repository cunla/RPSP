package com.emc.rpsp.vmwal;

import com.emc.rpsp.exceptions.RpspBackupVmNotFoundException;
import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.MorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Daniel Moran
 */
public class VSphereApi {
    private static final Logger log = LoggerFactory.getLogger(VSphereApi.class);
    private final String vcenter;
    private final String uname;
    private final String pwd;

    public ServiceInstance si;
    public Folder rootFolder;
    public Datacenter dc;
    public ManagedEntity[] resourcePool_list;
    public Datastore[] datastores;
    public ManagedEntity[] hosts;
    public ManagedEntity[] vms;
    public String vmName;
    public VirtualMachine vm;
    public HostSystem host;


//    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //Initial Configuration
    public VSphereApi(String vcenter, String uname, String pwd) {
        this.vcenter = vcenter;
        this.uname = uname;
        this.pwd = pwd;
        this.connect();
    }

    private void connect() {
        try {
            log.info("Connecting to vcenter {} using user {}", vcenter, uname);
            this.si = new ServiceInstance(new URL(vcenter), uname, pwd, true);
            rootFolder = si.getRootFolder();
            this.dc = (Datacenter) new InventoryNavigator(rootFolder).searchManagedEntities("Datacenter")[0];
            resourcePool_list = new InventoryNavigator(rootFolder).searchManagedEntities("ResourcePool");
            hosts = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
            vms = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
            datastores = dc.getDatastores();
            //ManagedEntity[] ds = new InventoryNavigator(rootFolder).searchManagedEntities("Datastore");
        } catch (Exception e) {
            log.error("{}", e.getMessage());
        }
    }

    public Boolean removeVM(String vmName) throws Exception {
        vm = (VirtualMachine) new InventoryNavigator(rootFolder)
            .searchManagedEntity("VirtualMachine", vmName);
        if (vmName == null) {
            log.warn("{} Not Found.", vmName);
            return false;
        }
        log.debug("{} removal is in process.. please wait ..", vmName);
        Task task = vm.destroy_Task();
        @SuppressWarnings("deprecation")
        String result = task.waitForMe();
        if (result == Task.SUCCESS) {
            log.info("{} VM removed successfully", vmName);
            return true;
        } else {
            log.warn("{} VM was not removed successfully", vmName);
            return false;
        }
    }

    public Boolean powerOnVM(String vmName) throws Exception {
        vm = (VirtualMachine) new InventoryNavigator(
            rootFolder).searchManagedEntity("VirtualMachine", vmName);
        if (vmName == null) {
            log.debug(vmName + " Not Found.");
            return false;
        }

        VirtualMachineRuntimeInfo vmri = (VirtualMachineRuntimeInfo) vm.getRuntime();
        if (vmri.getPowerState() == VirtualMachinePowerState.poweredOff) {
            Task task = vm.powerOnVM_Task(null);
            @SuppressWarnings("deprecation")
            String result = task.waitForMe();
            if (result == Task.SUCCESS) {
                log.debug("vm: {} powered on.", vm.getName());
                return true;
            } else {
                log.warn("The VM couldn't be Powerd On");
                return false;
            }
        } else {
            log.debug("{} is already PoweredOn", vm.getName());
            return true;
        }
    }

    public boolean powerOffVM(String vmName) throws Exception {
        vm = (VirtualMachine) new InventoryNavigator(
            rootFolder).searchManagedEntity("VirtualMachine", vmName);
        if (vmName == null) {
            log.debug("{} Not Found.", vmName);
            return false;
        }

        VirtualMachineRuntimeInfo vmri = (VirtualMachineRuntimeInfo) vm.getRuntime();
        if (vmri.getPowerState() == VirtualMachinePowerState.poweredOn) {
            Task task = vm.powerOffVM_Task();
            @SuppressWarnings("deprecation")
            String result = task.waitForMe();
            if (result == Task.SUCCESS) {
                log.debug("{} powered off.", vm.getName());
                return true;
            } else {
                log.warn("The VM couldn't be Powerd On");
                return false;
            }
        } else {
            log.debug(vm.getName() + " is already PoweredOff");
            return true;
        }
    }

    public List<String> vmsInFolder(String backupFolder) {
        try {
            InventoryNavigator inventoryNavigator = new InventoryNavigator(rootFolder);
            Folder folder = (Folder) inventoryNavigator.searchManagedEntity("Folder", backupFolder);
            ManagedEntity[] vms = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
            return listEntityNames(vms);
        } catch (RemoteException e) {
            log.warn("Couldn't get list of VMs");
            e.printStackTrace();
            return null;
        }
    }

    public List<String> vmNames() {
        return listEntityNames(vms);
    }

    public List<String> datastoreNames() {
        return listEntityNames(datastores);
    }

    public List<String> hostNames() {
        try {
            ManagedEntity[] hosts = new InventoryNavigator(rootFolder).searchManagedEntities(
                new String[][]{{"HostSystem", "name"},}, true);
            return listEntityNames(hosts);
        } catch (IOException e) {
            log.warn("Couldn't get list of hosts");
            return null;
        }
    }

    private List<String> listEntityNames(ManagedEntity[] entities) {
        List<String> res = new LinkedList<>();
        for (ManagedEntity entity : entities) {
            res.add(entity.getName());
        }
        return res;
    }

    public void cloneVM(String vmName, String folderName, String cloneName, String datastoreName, Boolean powerOn) throws Exception {
//        this.si = new ServiceInstance(new URL(vcenter), uname, pwd, true);
        rootFolder = si.getRootFolder();
        InventoryNavigator inventoryNavigator = new InventoryNavigator(rootFolder);
        vm = (VirtualMachine) inventoryNavigator.searchManagedEntity("VirtualMachine", vmName);
        if (vm == null) {
            log.warn("No VM {} found", vmName);
            throw new RpspBackupVmNotFoundException(vmName);
        }
//        if ("poweredOn".equals(vm.getRuntime().getPowerState().toString())) {
//            log.warn("The VM cannot be in  poweredOn State");
//            return;
//        }

        Datastore datastore = (Datastore) inventoryNavigator.searchManagedEntity("Datastore", datastoreName);
        if (null == datastore) {
            log.warn("No datastore {} found", datastoreName);
            return;
        }
        Folder folder = (Folder) inventoryNavigator.searchManagedEntity("Folder", folderName);
        ManagedObjectReference[] mor = MorUtil.createMORs(new Datastore[]{datastore});
        VirtualMachineCloneSpec cloneSpec = new VirtualMachineCloneSpec();
        VirtualMachineRelocateSpec location = new VirtualMachineRelocateSpec();
        location.setDatastore(mor[0]);
        cloneSpec.setLocation(location);
        cloneSpec.setPowerOn(powerOn);
        cloneSpec.setTemplate(false);
//        Folder folder = (Folder) vm.getParent();
        Task task = vm.cloneVM_Task(folder, cloneName, cloneSpec);
        log.debug("Launching the VM clone task. Please wait ...");

        @SuppressWarnings("deprecation")
        String status = task.waitForMe();
        if (status == Task.SUCCESS) {
            log.debug("VM got cloned successfully.");
        } else {
            log.debug("Failure -: VM cannot be cloned");
        }
    }

}
