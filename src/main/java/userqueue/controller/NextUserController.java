package userqueue.controller;

import org.springframework.web.bind.annotation.*;
import userqueue.model.User;
import userqueue.util.FileUtil;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/nextUser")
public class NextUserController {

    private int userQueueIndex = 0;

    @RequestMapping(value = "/generalUser", method = RequestMethod.GET, produces = "application/json")
    public User generalUser() {
        final List<String> USER_LIST = FileUtil.getUsersList("common_user.txt");
        assert USER_LIST != null;
        int userQueueSize = USER_LIST.size();

        System.out.println(userQueueIndex);
        if (userQueueIndex > userQueueSize-1) {
            userQueueIndex = 0;
        }
        String tmp = USER_LIST.get(userQueueIndex);

        String user = tmp.split(":")[0];
        System.out.println(user);
        String pass = tmp.split(":")[1];
        System.out.println(pass);

        User nextUser = new User();
        nextUser.setUsername(user);
        nextUser.setPassword(pass);

        incrementUserQueue();

        return nextUser;
    }


    @RequestMapping(value = "/incorrectPasswordUser", method = RequestMethod.GET, produces = "application/json")
    public User incorrectPasswordUser() {
        final List<String> USER_LIST = FileUtil.getUsersList("incorrect_password_user.txt");
        assert USER_LIST != null;
        int userQueueSize = USER_LIST.size();

        System.out.println(userQueueIndex);
        if (userQueueIndex > userQueueSize-1) {
            userQueueIndex = 0;
        }
        String tmp = USER_LIST.get(userQueueIndex);

        String user = tmp.split(":")[0];
        System.out.println(user);
        String pass = tmp.split(":")[1];
        System.out.println(pass);

        User nextUser = new User();
        nextUser.setUsername(user);
        nextUser.setPassword(pass);

        incrementUserQueue();

        return nextUser;
    }

    @RequestMapping(value = "/nonExistingUser", method = RequestMethod.GET, produces = "application/json")
    public User nonExistingUser() {
        final List<String> USER_LIST = FileUtil.getUsersList("non_existing_user.txt");
        assert USER_LIST != null;
        int userQueueSize = USER_LIST.size();

        System.out.println(userQueueIndex);
        if (userQueueIndex > userQueueSize-1) {
            userQueueIndex = 0;
        }
        String tmp = USER_LIST.get(userQueueIndex);

        String user = tmp.split(":")[0];
        System.out.println(user);
        String pass = tmp.split(":")[1];
        System.out.println(pass);

        User nextUser = new User();
        nextUser.setUsername(user);
        nextUser.setPassword(pass);

        incrementUserQueue();

        return nextUser;
    }

    private void incrementUserQueue() {
        userQueueIndex++;
    }
}
