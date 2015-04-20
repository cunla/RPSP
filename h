[1mdiff --git a/src/main/java/com/emc/rpsp/users/controller/UserController.java b/src/main/java/com/emc/rpsp/users/controller/UserController.java[m
[1mindex 8c229f6..9bc241b 100755[m
[1m--- a/src/main/java/com/emc/rpsp/users/controller/UserController.java[m
[1m+++ b/src/main/java/com/emc/rpsp/users/controller/UserController.java[m
[36m@@ -94,7 +94,7 @@[m [mpublic class UserController {[m
 		userService.deleteUser(id);[m
 		return new ResponseEntity<>(HttpStatus.NO_CONTENT);[m
 	}[m
[31m-	[m
[32m+[m[41m[m
 	@PreAuthorize("hasAuthority('ADMIN')")[m
 	@RequestMapping(value = "/users/login/{login}", method = RequestMethod.DELETE)[m
 	@ResponseBody[m
