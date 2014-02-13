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

-- Create syntax for TABLE 'game'
CREATE TABLE `game` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `guid` varchar(36) NOT NULL DEFAULT '',
  `turn` enum('RED','BLACK') NOT NULL DEFAULT 'BLACK',
  `status` enum('IN_PROGRESS','COMPLETE') NOT NULL DEFAULT 'IN_PROGRESS',
  `winner` enum('RED','BLACK','DRAW','NONE') NOT NULL DEFAULT 'NONE',
  `created_at` int(11) unsigned NOT NULL DEFAULT '0',
  `modified_at` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;

-- Create syntax for TABLE 'piece'
CREATE TABLE `piece` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `game_id` int(11) unsigned NOT NULL DEFAULT '0',
  `current_position` tinyint(2) unsigned NOT NULL DEFAULT '0',
  `color` enum('RED','BLACK') NOT NULL DEFAULT 'BLACK',
  `is_king` tinyint(1) NOT NULL DEFAULT '0',
  `created_at` int(11) unsigned NOT NULL DEFAULT '0',
  `modified_at` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;

-- Create syntax for TABLE 'piece_move'
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

*****

**POST:** /game/create

**Example Response:**

{"id":"cba044f5-94e0-11e3-9776-bc764e1149b8","turn":"BLACK","board":{"spacesPerSide":8,"pieces":[{"location":{"x":2,"y":0},"king":false,"team":"BLACK"},{"location":{"x":4,"y":0},"king":false,"team":"BLACK"},{"location":{"x":6,"y":0},"king":false,"team":"BLACK"},{"location":{"x":8,"y":0},"king":false,"team":"BLACK"},{"location":{"x":1,"y":1},"king":false,"team":"BLACK"},{"location":{"x":3,"y":1},"king":false,"team":"BLACK"},{"location":{"x":5,"y":1},"king":false,"team":"BLACK"},{"location":{"x":7,"y":1},"king":false,"team":"BLACK"},{"location":{"x":2,"y":2},"king":false,"team":"BLACK"},{"location":{"x":4,"y":2},"king":false,"team":"BLACK"},{"location":{"x":6,"y":2},"king":false,"team":"BLACK"},{"location":{"x":8,"y":2},"king":false,"team":"BLACK"},{"location":{"x":1,"y":5},"king":false,"team":"RED"},{"location":{"x":3,"y":5},"king":false,"team":"RED"},{"location":{"x":5,"y":5},"king":false,"team":"RED"},{"location":{"x":7,"y":5},"king":false,"team":"RED"},{"location":{"x":2,"y":6},"king":false,"team":"RED"},{"location":{"x":4,"y":6},"king":false,"team":"RED"},{"location":{"x":6,"y":6},"king":false,"team":"RED"},{"location":{"x":8,"y":6},"king":false,"team":"RED"},{"location":{"x":1,"y":7},"king":false,"team":"RED"},{"location":{"x":3,"y":7},"king":false,"team":"RED"},{"location":{"x":5,"y":7},"king":false,"team":"RED"},{"location":{"x":7,"y":7},"king":false,"team":"RED"}]}}


**GET:** /game/{$id}

**Example Response:**

{"id":"cba044f5-94e0-11e3-9776-bc764e1149b8","turn":"BLACK","board":{"spacesPerSide":8,"pieces":[{"location":{"x":2,"y":0},"king":false,"team":"BLACK"},{"location":{"x":4,"y":0},"king":false,"team":"BLACK"},{"location":{"x":6,"y":0},"king":false,"team":"BLACK"},{"location":{"x":8,"y":0},"king":false,"team":"BLACK"},{"location":{"x":1,"y":1},"king":false,"team":"BLACK"},{"location":{"x":3,"y":1},"king":false,"team":"BLACK"},{"location":{"x":5,"y":1},"king":false,"team":"BLACK"},{"location":{"x":7,"y":1},"king":false,"team":"BLACK"},{"location":{"x":2,"y":2},"king":false,"team":"BLACK"},{"location":{"x":4,"y":2},"king":false,"team":"BLACK"},{"location":{"x":6,"y":2},"king":false,"team":"BLACK"},{"location":{"x":8,"y":2},"king":false,"team":"BLACK"},{"location":{"x":1,"y":5},"king":false,"team":"RED"},{"location":{"x":3,"y":5},"king":false,"team":"RED"},{"location":{"x":5,"y":5},"king":false,"team":"RED"},{"location":{"x":7,"y":5},"king":false,"team":"RED"},{"location":{"x":2,"y":6},"king":false,"team":"RED"},{"location":{"x":4,"y":6},"king":false,"team":"RED"},{"location":{"x":6,"y":6},"king":false,"team":"RED"},{"location":{"x":8,"y":6},"king":false,"team":"RED"},{"location":{"x":1,"y":7},"king":false,"team":"RED"},{"location":{"x":3,"y":7},"king":false,"team":"RED"},{"location":{"x":5,"y":7},"king":false,"team":"RED"},{"location":{"x":7,"y":7},"king":false,"team":"RED"}]}}
