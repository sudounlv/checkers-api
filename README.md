checkers-api
============

**Build:**
mvn clean install

**Run:**
mvn jetty:run -Dapp.mode=dev|prod

**Test:**
http://localhost:2020/heartbeat/detail

*****

**SQL Table Creation**

CREATE TABLE `game` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `guid` varchar(36) NOT NULL DEFAULT '',
  `result` enum('RED_WIN','BLACK_WIN','RED_FORFEIT','BLACK_FORFEIT','DRAW','NONE') NOT NULL DEFAULT 'NONE',
  `created_at` int(11) unsigned NOT NULL DEFAULT '0',
  `modified_at` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=latin1;

CREATE TABLE `game_player` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `player_id` int(11) unsigned NOT NULL DEFAULT '0',
  `game_id` int(11) NOT NULL DEFAULT '0',
  `is_creator` tinyint(1) NOT NULL DEFAULT '0',
  `is_turn` tinyint(1) NOT NULL DEFAULT '0',
  `color` enum('RED','BLACK') NOT NULL DEFAULT 'BLACK',
  `created_at` int(11) unsigned NOT NULL DEFAULT '0',
  `modified_at` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

CREATE TABLE `piece` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `game_id` int(11) unsigned NOT NULL DEFAULT '0',
  `current_position` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `color` enum('RED','BLACK') NOT NULL DEFAULT 'BLACK',
  `is_king` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` int(11) unsigned NOT NULL DEFAULT '0',
  `modified_at` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=169 DEFAULT CHARSET=latin1;

CREATE TABLE `piece_move` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `piece_id` int(11) unsigned NOT NULL DEFAULT '0',
  `start_position` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `end_position` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `move_type` enum('MOVE','CAPTURE') NOT NULL DEFAULT 'MOVE',
  `created_at` int(11) unsigned NOT NULL DEFAULT '0',
  `modified_at` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `player` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `device_id` varchar(256) DEFAULT NULL,
  `created_at` int(11) unsigned NOT NULL DEFAULT '0',
  `modified_at` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

*****

**POST:** /game/create

**Required Params:**
* **deviceId** *String* - id that uniquely identifies the device
* **color** *String (BLACK|RED)* - color that the game creator will play as

**Example Request**

http://localhost:9090/game/create?deviceId=my-super-unique-device-id&color=BLACK

**Example Response:**

{"id":"5bded970-9754-11e3-8939-d66c99bbdc1d","turn":"BLACK","board":{"spacesPerSide":8,"pieces":[{"location":{"x":2,"y":0},"king":false,"team":"BLACK"},{"location":{"x":4,"y":0},"king":false,"team":"BLACK"},{"location":{"x":6,"y":0},"king":false,"team":"BLACK"},{"location":{"x":8,"y":0},"king":false,"team":"BLACK"},{"location":{"x":1,"y":1},"king":false,"team":"BLACK"},{"location":{"x":3,"y":1},"king":false,"team":"BLACK"},{"location":{"x":5,"y":1},"king":false,"team":"BLACK"},{"location":{"x":7,"y":1},"king":false,"team":"BLACK"},{"location":{"x":2,"y":2},"king":false,"team":"BLACK"},{"location":{"x":4,"y":2},"king":false,"team":"BLACK"},{"location":{"x":6,"y":2},"king":false,"team":"BLACK"},{"location":{"x":8,"y":2},"king":false,"team":"BLACK"},{"location":{"x":1,"y":5},"king":false,"team":"RED"},{"location":{"x":3,"y":5},"king":false,"team":"RED"},{"location":{"x":5,"y":5},"king":false,"team":"RED"},{"location":{"x":7,"y":5},"king":false,"team":"RED"},{"location":{"x":2,"y":6},"king":false,"team":"RED"},{"location":{"x":4,"y":6},"king":false,"team":"RED"},{"location":{"x":6,"y":6},"king":false,"team":"RED"},{"location":{"x":8,"y":6},"king":false,"team":"RED"},{"location":{"x":1,"y":7},"king":false,"team":"RED"},{"location":{"x":3,"y":7},"king":false,"team":"RED"},{"location":{"x":5,"y":7},"king":false,"team":"RED"},{"location":{"x":7,"y":7},"king":false,"team":"RED"}]}}

*****

**POST:** /game/{$gameId}/join/{$deviceId}

**Required Params:**
* None

**Example Request:**

http://localhost:9090/game/5bded970-9754-11e3-8939-d66c99bbdc1d/join/my-second-super-unique-device-id

**Example Response:**

{"id":"5bded970-9754-11e3-8939-d66c99bbdc1d","turn":"BLACK","board":{"spacesPerSide":8,"pieces":[{"location":{"x":2,"y":0},"king":false,"team":"BLACK"},{"location":{"x":4,"y":0},"king":false,"team":"BLACK"},{"location":{"x":6,"y":0},"king":false,"team":"BLACK"},{"location":{"x":8,"y":0},"king":false,"team":"BLACK"},{"location":{"x":1,"y":1},"king":false,"team":"BLACK"},{"location":{"x":3,"y":1},"king":false,"team":"BLACK"},{"location":{"x":5,"y":1},"king":false,"team":"BLACK"},{"location":{"x":7,"y":1},"king":false,"team":"BLACK"},{"location":{"x":2,"y":2},"king":false,"team":"BLACK"},{"location":{"x":4,"y":2},"king":false,"team":"BLACK"},{"location":{"x":6,"y":2},"king":false,"team":"BLACK"},{"location":{"x":8,"y":2},"king":false,"team":"BLACK"},{"location":{"x":1,"y":5},"king":false,"team":"RED"},{"location":{"x":3,"y":5},"king":false,"team":"RED"},{"location":{"x":5,"y":5},"king":false,"team":"RED"},{"location":{"x":7,"y":5},"king":false,"team":"RED"},{"location":{"x":2,"y":6},"king":false,"team":"RED"},{"location":{"x":4,"y":6},"king":false,"team":"RED"},{"location":{"x":6,"y":6},"king":false,"team":"RED"},{"location":{"x":8,"y":6},"king":false,"team":"RED"},{"location":{"x":1,"y":7},"king":false,"team":"RED"},{"location":{"x":3,"y":7},"king":false,"team":"RED"},{"location":{"x":5,"y":7},"king":false,"team":"RED"},{"location":{"x":7,"y":7},"king":false,"team":"RED"}]}}

*****

**GET:** /game/{gameId}

**Required Params:**
* None

**Example Request:**

http://localhost:9090/game/5bded970-9754-11e3-8939-d66c99bbdc1d

**Example Response:**

{"id":"5bded970-9754-11e3-8939-d66c99bbdc1d","turn":"BLACK","board":{"spacesPerSide":8,"pieces":[{"location":{"x":2,"y":0},"king":false,"team":"BLACK"},{"location":{"x":4,"y":0},"king":false,"team":"BLACK"},{"location":{"x":6,"y":0},"king":false,"team":"BLACK"},{"location":{"x":8,"y":0},"king":false,"team":"BLACK"},{"location":{"x":1,"y":1},"king":false,"team":"BLACK"},{"location":{"x":3,"y":1},"king":false,"team":"BLACK"},{"location":{"x":5,"y":1},"king":false,"team":"BLACK"},{"location":{"x":7,"y":1},"king":false,"team":"BLACK"},{"location":{"x":2,"y":2},"king":false,"team":"BLACK"},{"location":{"x":4,"y":2},"king":false,"team":"BLACK"},{"location":{"x":6,"y":2},"king":false,"team":"BLACK"},{"location":{"x":8,"y":2},"king":false,"team":"BLACK"},{"location":{"x":1,"y":5},"king":false,"team":"RED"},{"location":{"x":3,"y":5},"king":false,"team":"RED"},{"location":{"x":5,"y":5},"king":false,"team":"RED"},{"location":{"x":7,"y":5},"king":false,"team":"RED"},{"location":{"x":2,"y":6},"king":false,"team":"RED"},{"location":{"x":4,"y":6},"king":false,"team":"RED"},{"location":{"x":6,"y":6},"king":false,"team":"RED"},{"location":{"x":8,"y":6},"king":false,"team":"RED"},{"location":{"x":1,"y":7},"king":false,"team":"RED"},{"location":{"x":3,"y":7},"king":false,"team":"RED"},{"location":{"x":5,"y":7},"king":false,"team":"RED"},{"location":{"x":7,"y":7},"king":false,"team":"RED"}]}}
