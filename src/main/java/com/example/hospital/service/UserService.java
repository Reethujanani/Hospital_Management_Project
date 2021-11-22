package com.example.hospital.service;

import com.example.hospital.dto.TokenDTO;
import com.example.hospital.dto.UserDTO;
import com.example.hospital.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {

    UserDTO addUser(UserDTO user);

    Page<User> listAllDetails(int pageNo , int pageSize, String sortBy);

    User getProductDetailsByID(int id);

    UserDTO updateProductDetails(UserDTO product);

    String deleteDetailsById(int id);

    String login(TokenDTO tokenDTO);

    UserDetails loadByUserName(String userName);
}
