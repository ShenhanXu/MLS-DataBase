//package com.mls.database.rest.webservices.restfulwebservices.player;
//
//import java.util.List;
//import java.util.Optional;
//
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/players")
//public class PlayerJPAResources {
//
//    private PlayerRepository playerRepository;
//
//    public PlayerJPAResources(PlayerRepository playerRepository) {
//        this.playerRepository = playerRepository;
//    }
//
//    @GetMapping("/all")
//    public List<Player> retrieveAllPlayers() {
//        return playerRepository.findAll();
//    }
//
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Player> retrievePlayer(@PathVariable int id) {
//        Optional<Player> player = playerRepository.findById(id);
//        return player.map(ResponseEntity::ok)
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("")
//    public Player createPlayer(@RequestBody Player player) {
//        return playerRepository.save(player);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Player> updatePlayer(@PathVariable int id, @RequestBody Player playerDetails) {
//        return playerRepository.findById(id)
//                .map(player -> {
//                    player.setName(playerDetails.getName());
//                    player.setPosition(playerDetails.getPosition());
//                    player.setTeam(playerDetails.getTeam());
//                    return ResponseEntity.ok(playerRepository.save(player));
//                }).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {
//        return playerRepository.findById(id)
//                .map(player -> {
//                    playerRepository.delete(player);
//                    return ResponseEntity.ok().<Void>build();
//                }).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//}
