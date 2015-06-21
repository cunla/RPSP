package com.emc.rpsp.vms.service.impl;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.accounts.repository.AccountRepository;
import com.emc.rpsp.vms.domain.VmOwnership;
import com.emc.rpsp.vms.repository.VmOwnershipRepository;
import com.emc.rpsp.vms.service.VmOwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

@Service public class VmOwnershipServiceImpl implements VmOwnershipService {

    @Autowired private VmOwnershipRepository vmOwnershipRepository;

    @PersistenceContext private EntityManager entityManager;

    @Autowired private AccountRepository accountRepository;

    @Override public List<VmOwnership> findAll() {
        List<VmOwnership> vmOwnership = vmOwnershipRepository.findAll();
        return vmOwnership;
    }

    @Override public VmOwnership findById(Long id) {
        VmOwnership vmOwnership = vmOwnershipRepository.findOne(id);
        return vmOwnership;
    }

    @Override public VmOwnership findByVmId(String vmId) {
        VmOwnership vmOwnership = vmOwnershipRepository.findOneByVmId(vmId);
        return vmOwnership;
    }


/*	@Override
    @Transactional
	public Account create(Account account, Long systemId) {
		entityManager.persist(account);
		entityManager.flush();
		SystemSettings systemSettings = systemConnectionInfoRepository.findOne(systemId);
		account.setSystemSettings(systemSettings);
		Account newAccount = entityManager.merge(account);
		entityManager.flush();
		return newAccount;
	}*/

    @Override @Transactional public VmOwnership create(VmOwnership vmOwnership, Long accountId) {
        entityManager.persist(vmOwnership);
        entityManager.flush();
        Account account = accountRepository.findOne(accountId);
        vmOwnership.setAccount(account);
        VmOwnership createdVmOwnership = entityManager.merge(vmOwnership);
        entityManager.flush();
        return createdVmOwnership;
    }

    @Override public List<VmOwnership> bulkCreate(List<VmOwnership> vmOwnership) {
        List<VmOwnership> createdVmOwnershipList = new LinkedList<VmOwnership>();
        for (VmOwnership currVmOwnership : vmOwnership) {
            VmOwnership createdVmOwnership = vmOwnershipRepository.save(currVmOwnership);
            createdVmOwnershipList.add(createdVmOwnership);
        }
        return createdVmOwnershipList;
    }

    @Override public void delete(Long id) {
        vmOwnershipRepository.delete(id);
        return;

    }

}
