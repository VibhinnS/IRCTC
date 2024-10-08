package org.example.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.entities.Ticket;
import org.example.entities.User;
import org.example.utils.UserServiceUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class UserBookingService {

    private User user;
    private List<User> userList;
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final String USERS_PATH = "../local/users.json";

    public UserBookingService(User user1) throws IOException {
        this.user = user1;
        File users = new File(USERS_PATH);
        userList = objectMapper.readValue(users, new TypeReference<>() {
        });
    }

    public UserBookingService() throws IOException {
        loadUsers();
    }

    public void loadUsers() throws IOException {
        File users = new File(USERS_PATH);
        objectMapper.readValue(users, new TypeReference<>() {
        });
    }

    public boolean loginUser() {
        Optional<User> foundUser = userList.stream().filter(user1 -> user1.getName().equals(user.getName()) && UserServiceUtil.checkPassword(user.getPassword(), user1)).findFirst();
        return foundUser.isPresent();
    }

    public boolean signUp(User user1) {
        try {
            userList.add(user1);
            saveUserListToFile();
            return Boolean.TRUE;
        } catch(IOException ex) {
            return Boolean.FALSE;
        }
    }

    public void saveUserListToFile() throws IOException{
        File usersFile = new File(USERS_PATH);
        objectMapper.writeValue(usersFile, userList);
    }

    public void fetchBooking() {
        user.printTickets();
    }

    public Boolean cancelBooking(String ticketId) throws IOException {
        List<Ticket> bookedTicketsByUser = user.getTicketsBooked();

        for (Ticket ticket : bookedTicketsByUser) {
            if (ticket.getTicketId().equals(ticketId)) {
                bookedTicketsByUser.remove(ticket);
                saveUserListToFile();
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
