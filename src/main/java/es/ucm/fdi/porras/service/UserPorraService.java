package es.ucm.fdi.porras.service;

import es.ucm.fdi.porras.model.Porra;
import es.ucm.fdi.porras.model.Role;
import es.ucm.fdi.porras.model.User;
import es.ucm.fdi.porras.model.UserPorra;
import es.ucm.fdi.porras.repository.RoleRepository;
import es.ucm.fdi.porras.repository.UserPorraRepository;
import es.ucm.fdi.porras.repository.UserRepository;
import es.ucm.fdi.porras.model.RolesConstants;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * Service class for managing users.
 */
@Service
@Transactional
@Slf4j
public class UserPorraService {

    private final UserRepository userRepository;

    private final RoleRepository rolesRepository;
    
    private final UserPorraRepository userporraRepository;

    private final PasswordEncoder passwordEncoder;

    public UserPorraService(UserPorraRepository userporraRepository, UserRepository userRepository, RoleRepository rolesRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.rolesRepository = rolesRepository;
        this.passwordEncoder = passwordEncoder;
        this.userporraRepository = userporraRepository;
    }

/*    public Optional<User> activateRegistration(String key) {
        log.debug("Activating user for activation key {}", key);
        return userRepository.findOneByActivationKey(key)
            .map(user -> {
                // activate given user for the registration key.
                user.setActivated(true);
                user.setActivationKey(null);
                userSearchRepository.save(user);
                log.debug("Activated user: {}", user);
                return user;
            });
    }

    public Optional<User> completePasswordReset(String newPassword, String key) {
       log.debug("Reset user password for reset key {}", key);

       return userRepository.findOneByResetKey(key)
           .filter(user -> user.getResetDate().isAfter(Instant.now().minusSeconds(86400)))
           .map(user -> {
                user.setPassword(passwordEncoder.encode(newPassword));
                user.setResetKey(null);
                user.setResetDate(null);
                return user;
           });
    }

    public Optional<User> requestPasswordReset(String mail) {
        return userRepository.findOneByEmail(mail)
            .filter(User::getActivated)
            .map(user -> {
                user.setResetKey(RandomUtil.generateResetKey());
                user.setResetDate(Instant.now());
                return user;
            });
    }*/

    public User createUser(String login, String password, String firstName, String lastName, String email,
        String imageUrl) {

        User newUser = new User();
        Role role = rolesRepository.findOne(RolesConstants.USER);
        Set<Role> roles = new HashSet<>();
        String encryptedPassword = passwordEncoder.encode(password);
        newUser.setLogin(login);
        // new user gets initially a generated password
        newUser.setPassword(password);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setImageUrl(imageUrl);
        // new user is not active
        newUser.setActivated(false);
        // new user gets registration key
        //newUser.setActivationKey(RandomStringUtils.randomNumeric(20));
        roles.add(role);
        newUser.setRoles(roles);
        userRepository.save(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }

	public List<Porra> porrasbyUsuario(User u) {
		// TODO Auto-generated method stub
		List<Porra> lp = null;
		List<UserPorra> lpu = this.userporraRepository.findAllByUser(u);
		int size = lpu.size();
		lp = new ArrayList<Porra>();
		for(int i = 0; i < size; i++){
			UserPorra aux = lpu.get(i);
			lp.add(aux.getPorra());
		}
		return lp;
	}

    /*public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setLogin(userDTO.getLogin());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setImageUrl(userDTO.getImageUrl());
        if (userDTO.getLangKey() == null) {
            user.setLangKey("es"); // default language
        } else {
            user.setLangKey(userDTO.getLangKey());
        }
        if (userDTO.getRoles() != null) {
            Set<Role> roles = new HashSet<>();
            userDTO.getRoles().forEach(
                role -> roles.add(rolesRepository.findOne(role))
            );
            user.setRoles(roles);
        }
        String encryptedPassword = passwordEncoder.encode(RandomUtil.generatePassword());
        user.setPassword(encryptedPassword);
        user.setResetKey(RandomUtil.generateResetKey());
        user.setResetDate(Instant.now());
        user.setActivated(true);
        userRepository.save(user);
        userSearchRepository.save(user);
        log.debug("Created Information for User: {}", user);
        return user;
    }

    *//**
     * Update basic information (first name, last name, email, language) for the current user.
     *
     * @param firstName first name of user
     * @param lastName last name of user
     * @param email email id of user
     * @param langKey language key
     * @param imageUrl image URL of user
     *//*
    public void updateUser(String firstName, String lastName, String email, String langKey, String imageUrl) {
        userRepository.findOneByLogin(SecurityUtils.getCurrentUserLogin()).ifPresent(user -> {
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setLangKey(langKey);
            user.setImageUrl(imageUrl);
            userSearchRepository.save(user);
            log.debug("Changed Information for User: {}", user);
        });
    }

    *//**
     * Update all information for a specific user, and return the modified user.
     *
     * @param userDTO user to update
     * @return updated user
     *//*
    public Optional<UserDTO> updateUser(UserDTO userDTO) {
        return Optional.of(userRepository
            .findOne(userDTO.getId()))
            .map(user -> {
                user.setLogin(userDTO.getLogin());
                user.setFirstName(userDTO.getFirstName());
                user.setLastName(userDTO.getLastName());
                user.setEmail(userDTO.getEmail());
                user.setImageUrl(userDTO.getImageUrl());
                user.setActivated(userDTO.isActivated());
                user.setLangKey(userDTO.getLangKey());
                Set<Role> managedRoles = user.getRoles();
                managedRoles.clear();
                userDTO.getRoles().stream()
                    .map(rolesRepository::findOne)
                    .forEach(managedRoles::add);
                log.debug("Changed Information for User: {}", user);
                return user;
            })
            .map(UserDTO::new);
    }

    public void deleteUser(String login) {
        userRepository.findOneByLogin(login).ifPresent(user -> {
            socialService.deleteUserSocialConnection(user.getLogin());
            userRepository.delete(user);
            userSearchRepository.delete(user);
            log.debug("Deleted User: {}", user);
        });
    }

    public void changePassword(String password) {
        userRepository.findOneByLogin(SecurityUtils.getCurrentUserLogin()).ifPresent(user -> {
            String encryptedPassword = passwordEncoder.encode(password);
            user.setPassword(encryptedPassword);
            log.debug("Changed password for User: {}", user);
        });
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> getAllManagedUsers(Pageable pageable) {
        return userRepository.findAllByLoginNot(pageable, Constants.ANONYMOUS_USER).map(UserDTO::new);
    }

    @Transactional(readOnly = true)
    public Optional<User> getUserWithRolesByLogin(String login) {
        return userRepository.findOneWithRolesByLogin(login);
    }

    @Transactional(readOnly = true)
    public User getUserWithRoles(Long id) {
        return userRepository.findOneWithRolesById(id);
    }

    @Transactional(readOnly = true)
    public User getUserWithRoles() {
        return userRepository.findOneWithRolesByLogin(SecurityUtils.getCurrentUserLogin()).orElse(null);
    }


    *//**
     * Not activated users should be automatically deleted after 3 days.
     * <p>
     * This is scheduled to get fired everyday, at 01:00 (am).
     * </p>
     *//*
    @Scheduled(cron = "0 0 1 * * ?")
    public void removeNotActivatedUsers() {
        List<User> users = userRepository.findAllByActivatedIsFalseAndCreatedDateBefore(Instant.now().minus(3, ChronoUnit.DAYS));
        for (User user : users) {
            log.debug("Deleting not activated user {}", user.getLogin());
            userRepository.delete(user);
            userSearchRepository.delete(user);
        }
    }

    *//**
     * @return a list of all the roles
     *//*
    public List<String> getRoles() {
        return rolesRepository.findAll().stream().map(Role::getName).collect(Collectors.toList());
    }*/
}
