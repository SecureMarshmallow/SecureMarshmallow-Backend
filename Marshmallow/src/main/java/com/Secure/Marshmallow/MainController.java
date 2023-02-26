package com.Secure.Marshmallow;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class MainController {

    @Autowired
    private UserRepository userRepository;
    private BoardRepository boardRepository;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else if (user != null) {
            return ResponseEntity.ok(user);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<User> Register(@RequestParam String username, @RequestParam String password,@RequestParam String id,@RequestParam String gmail) {
        User user = userRepository.Register(username, password, id, gmail);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else if (user != null) {
            return ResponseEntity.ok(user);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/write_ok")
    public ResponseEntity<User> writePost(@RequestParam String title, @RequestParam String writer,@RequestParam String content,@RequestParam String password) {
        Board board = (Board) boardRepository.writePost(title, writer, content, password);
        if (board == null)
        {
            return ResponseEntity.notFound().build();
        }
        else if (board != null)
        {
            return ResponseEntity.ok((User) board);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/viewPost")
    public ResponseEntity<User> viewPost(@RequestParam int idx) {
        Board board = (Board) boardRepository.viewPost(idx);
        if (board == null)
        {
            return ResponseEntity.notFound().build();
        }
        else if (board != null)
        {
            return ResponseEntity.ok((User) board);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
