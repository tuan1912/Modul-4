package tuan.nguyen.jwtsecurity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import tuan.nguyen.jwtsecurity.entity.AuthRequest;
import tuan.nguyen.jwtsecurity.util.JwtUtil;


@RestController
public class WelcomeController {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        String wel = "Welcome";
        return new ResponseEntity<>(wel, HttpStatus.ACCEPTED);
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            return "invalid";
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
}
