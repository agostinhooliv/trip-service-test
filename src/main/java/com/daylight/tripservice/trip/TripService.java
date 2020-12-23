package com.daylight.tripservice.trip;

import com.daylight.tripservice.exception.UserNotLoggedInException;
import com.daylight.tripservice.user.User;
import com.daylight.tripservice.user.UserSession;

import java.util.ArrayList;
import java.util.List;

public class TripService {

    private boolean activeLogin = false;

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {
        List<Trip> tripList = new ArrayList<Trip>();
        User loggedUser = getLoggedUser();
        boolean isFriend = false;
        if (loggedUser != null) {
            for (User friend : user.getFriends()) {
                if (friend.equals(loggedUser)) {
                    isFriend = true;
                    break;
                }
            }

            if (isFriend) {
                tripList = findTripsByUser(user);
            }
            return tripList;
        } else {
            throw new UserNotLoggedInException();
        }
    }

    public List<Trip> findTripsByUser(User user) {
        return TripDAO.findTripsByUser(user);
    }

    public User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }

    public boolean isActiveLogin() {
        return activeLogin;
    }

    public void setActiveLogin(boolean activeLogin) {
        this.activeLogin = activeLogin;
    }
}
