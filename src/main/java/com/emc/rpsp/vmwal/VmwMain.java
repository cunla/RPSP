package com.emc.rpsp.vmwal;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by morand3 on 12/27/2015.
 */
public class VmwMain {
    private static final Logger log = LoggerFactory.getLogger(VmwMain.class);

   /* public static void main(String[] args) {
        String vcenter = "https://10.64.125.35/sdk";
        String uname = "administrator@vsphere.local";
        String pwd = "DmBU@EMC!2014";
        VSphereApi vmwareClient = new VSphereApi(vcenter, uname, pwd);
        List<String> vms = vmwareClient.vmNames();
        System.out.println(vms.size() + " VMs: \n" + StringUtils.join(vms, ","));
        List<String> hosts = vmwareClient.hostNames();
        System.out.println(hosts.size() + " Hosts: \n" + StringUtils.join(hosts, ","));
        List<String> datastores = vmwareClient.datastoreNames();
        System.out.println(datastores.size() + " Datastores: \n" + StringUtils.join(datastores, ","));

        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter VM name to clone");
        String vmToClone = "tstA2";
//        System.out.println("Enter datastore to clone to");
        String datastore = "DDVE-2_backup";
        String folderName = "DD-backup";
        String newVmName = vmToClone + DateFormatUtils.format(new Date(), "_yyyy-MM-dd");
        log.info("Cloning vm {} to {} with new name {}", vmToClone, datastore, newVmName);

        try {
            vmwareClient.cloneVM(vmToClone, folderName, newVmName, datastore, false);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("VM cloned... press enter to delete");
        scanner.nextLine();
        try {
            vmwareClient.removeVM(newVmName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Clone deleted");
    }*/
}
