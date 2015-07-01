package com.emc.rpsp.imageaccess.service.impl;

import com.emc.rpsp.accounts.domain.Account;
import com.emc.rpsp.fal.Client;
import com.emc.rpsp.imageaccess.service.GroupCopiesImageAccessService;
import com.emc.rpsp.rpsystems.SystemSettings;
import com.emc.rpsp.users.service.UserService;
import com.emc.rpsp.vmstructure.domain.CopySnapshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service public class GroupCopiesImageAccessServiceImpl implements GroupCopiesImageAccessService {

    @Autowired private UserService userService = null;

    @Override public void enableLatestImageAccess(Long clusterId, Long groupId, Integer copyId) {
        Account account = userService.findCurrentUser().getUser().getAccount();
        if (account != null) {
            SystemSettings system = account.getSystemSettings().get(0);
            Client client = new Client(system);
            client.enableLatestImageAccess(clusterId, groupId, copyId);
        }

    }

    @Override public void enableSnapshotImageAccess(Long clusterId, Long groupId, int copyId,
    CopySnapshot copySnapshot) {
        Account account = userService.findCurrentUser().getUser().getAccount();
        if (account != null) {
            SystemSettings system = account.getSystemSettings().get(0);
            Client client = new Client(system);
            client.enableSnapshotImageAccess(clusterId, groupId, copyId, copySnapshot);
        }

    }

    @Override public void disableImageAccess(Long clusterId, Long groupId, Integer copyId) {
        Account account = userService.findCurrentUser().getUser().getAccount();
        if (account != null) {
            SystemSettings system = account.getSystemSettings().get(0);
            Client client = new Client(system);
            client.disableImageAccess(clusterId, groupId, copyId);
        }
    }

}
