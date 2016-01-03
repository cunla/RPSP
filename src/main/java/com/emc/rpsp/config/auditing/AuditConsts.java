package com.emc.rpsp.config.auditing;


public interface AuditConsts {

    public static final String CG = "cd";
    public static final String VM = "vm";
    public static final String GS = "gs";
    public static final String COPY = "copy";
    public static final String CLUSTER = "cluster";
    public static final String ENABLE_DR_TEST = "Enable DR test";
    public static final String DISABLE_DR_TEST = "Disable DR test";
    public static final String DR_TEST_RESULT = "dr_test_result";
    public static final String DISABLE_DR_TEST_RESULT = "disable_dr_test_result";
    public static final String CREATE_BOOKMARK = "Create bookmark";
    public static final String CREATE_BOOKMARK_RESULT = "create_bookmark_result";
    public static final String BOOKMARK_PARAMS = "bookmark_params";
    public static final String FAILOVER = "Failover";
    public static final String FAILOVER_RESULT = "failover_result";
    public static final String RECOVER_PRODUCTION = "Recover production";
    public static final String RECOVER_PRODUCTION_RESULT = "recover_production_result";
    public static final String LOGIN_ACTION = "Login";
    public static final String LOGOUT_ACTION = "Logout";
    public static final String LOGIN_LOGOUT_SUCCESS_RESULT = "OK";
    public static final String LOGIN_LOGOUT_FAILURE_RESULT = "Failure";
    public static final String CREATE_CG = "Create CG";
    public static final String CREATE_CG_SUBJ_PARAMS = "create_cg_subj_params";
    public static final String CREATE_CG_OBJ_PARAMS = "create_cg_obj_params";
    public static final String CREATE_CG_RESULT = "create_cg_result";
    public static final String ADD_VM_TO_CG = "Add VM to CG";
    public static final String ADD_VM_TO_CG_PARAMS = "add_vm_to_cg_params";
    public static final String ADD_VM_TO_CG_RESULT = "add_vm_to_cg_result";
    public static final String REMOVE_VM_FROM_CG = "Remove VM from CG";
    public static final String REMOVE_VM_FROM_CG_PARAMS = "remove_vm_from_cg_params";
    public static final String REMOVE_VM_FROM_CG_RESULT = "remove_vm_from_cg_result";

    public static final String ENABLE_BACKUP_ACCESS = "Enable backup access";
    public static final String DISABLE_BACKUP_ACCESS = "Disable backup access";
    public static final String TASK_STATUS = "task_status";

    public static final String TASK = "task";
    String BACKUP_NAME = "backup_name";
    String TASKS = "tasks";
}
