package com.javarush.jira.profile.web;

import com.javarush.jira.MatcherFactory;
import com.javarush.jira.profile.ContactTo;
import com.javarush.jira.profile.ProfileTo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.javarush.jira.login.internal.web.UserTestData.USER_ID;

public class ProfileTestData {
    public static final MatcherFactory.Matcher<ProfileTo> PROFILE_TO_MATCHER = MatcherFactory
            .usingIgnoringFieldsComparator(ProfileTo.class, "lastLogin", "contacts");

    public static ProfileTo getUpdated() {
        Set<ContactTo> contacts = new HashSet<>((Arrays.asList(new ContactTo("github", "new"))));
        Set<String> mailNotifications = new HashSet<>(Arrays.asList("deadline", "overdue"));

        return new ProfileTo(USER_ID, mailNotifications, contacts);
    }
}
