package com.solvd.laba.sinder.web.controller;

import com.solvd.laba.sinder.domain.partymatch.PartyMatch;
import com.solvd.laba.sinder.domain.user.User;
import com.solvd.laba.sinder.service.PartyMatchService;
import com.solvd.laba.sinder.service.UserService;
import com.solvd.laba.sinder.web.dto.PartyMatchDto;
import com.solvd.laba.sinder.web.dto.UserDto;
import com.solvd.laba.sinder.web.dto.mapper.PartyMatchMapper;
import com.solvd.laba.sinder.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/{userId}/parties/{partyId}/guests")
public class GuestController {

    private final UserService userService;
    private final PartyMatchService partyMatchService;
    private final UserMapper userMapper;
    private final PartyMatchMapper partyMatchMapper;

    @GetMapping()
    public List<UserDto> getAppropriate(@PathVariable Long userId, @PathVariable Long partyId) {
        List<User> guests = userService.retrieveGuestsFor(partyId);
        return guests.stream().map(userMapper::toDto).toList();
    }

    @GetMapping("/{guestId}")
    public UserDto getById(@PathVariable Long userId, @PathVariable String partyId, @PathVariable Long guestId) {
        User guest = userService.retrieveById(guestId);
        return userMapper.toDto(guest); //todo another dto
    }

    @PostMapping("/{guestId}/invite")
    public PartyMatchDto invite(@PathVariable Long userId, @PathVariable Long partyId, @PathVariable Long guestId) {
        PartyMatch partyMatch = partyMatchService.inviteGuest(partyId, guestId);
        return partyMatchMapper.toDto(partyMatch);
    }

    @PostMapping("/{guestId}/skip")
    public PartyMatchDto skip(@PathVariable Long userId, @PathVariable Long partyId, @PathVariable Long guestId) {
        PartyMatch partyMatch = partyMatchService.skipGuest(partyId, guestId);
        return partyMatchMapper.toDto(partyMatch);
    }

}
