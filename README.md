checkers-api
============

**Build:**
mvn clean install

**Run:**
mvn jetty:run -Dapp.mode=dev|prod

**Test:**
http://localhost:2020/heartbeat/detail

*****

**POST:** /game/create

**Example Response:**

{"id":"cba044f5-94e0-11e3-9776-bc764e1149b8","turn":"BLACK","board":{"spacesPerSide":8,"pieces":[{"location":{"x":2,"y":0},"king":false,"team":"BLACK"},{"location":{"x":4,"y":0},"king":false,"team":"BLACK"},{"location":{"x":6,"y":0},"king":false,"team":"BLACK"},{"location":{"x":8,"y":0},"king":false,"team":"BLACK"},{"location":{"x":1,"y":1},"king":false,"team":"BLACK"},{"location":{"x":3,"y":1},"king":false,"team":"BLACK"},{"location":{"x":5,"y":1},"king":false,"team":"BLACK"},{"location":{"x":7,"y":1},"king":false,"team":"BLACK"},{"location":{"x":2,"y":2},"king":false,"team":"BLACK"},{"location":{"x":4,"y":2},"king":false,"team":"BLACK"},{"location":{"x":6,"y":2},"king":false,"team":"BLACK"},{"location":{"x":8,"y":2},"king":false,"team":"BLACK"},{"location":{"x":1,"y":5},"king":false,"team":"RED"},{"location":{"x":3,"y":5},"king":false,"team":"RED"},{"location":{"x":5,"y":5},"king":false,"team":"RED"},{"location":{"x":7,"y":5},"king":false,"team":"RED"},{"location":{"x":2,"y":6},"king":false,"team":"RED"},{"location":{"x":4,"y":6},"king":false,"team":"RED"},{"location":{"x":6,"y":6},"king":false,"team":"RED"},{"location":{"x":8,"y":6},"king":false,"team":"RED"},{"location":{"x":1,"y":7},"king":false,"team":"RED"},{"location":{"x":3,"y":7},"king":false,"team":"RED"},{"location":{"x":5,"y":7},"king":false,"team":"RED"},{"location":{"x":7,"y":7},"king":false,"team":"RED"}]}}


**GET:** /game/{$id}

**Example Response:**

{"id":"cba044f5-94e0-11e3-9776-bc764e1149b8","turn":"BLACK","board":{"spacesPerSide":8,"pieces":[{"location":{"x":2,"y":0},"king":false,"team":"BLACK"},{"location":{"x":4,"y":0},"king":false,"team":"BLACK"},{"location":{"x":6,"y":0},"king":false,"team":"BLACK"},{"location":{"x":8,"y":0},"king":false,"team":"BLACK"},{"location":{"x":1,"y":1},"king":false,"team":"BLACK"},{"location":{"x":3,"y":1},"king":false,"team":"BLACK"},{"location":{"x":5,"y":1},"king":false,"team":"BLACK"},{"location":{"x":7,"y":1},"king":false,"team":"BLACK"},{"location":{"x":2,"y":2},"king":false,"team":"BLACK"},{"location":{"x":4,"y":2},"king":false,"team":"BLACK"},{"location":{"x":6,"y":2},"king":false,"team":"BLACK"},{"location":{"x":8,"y":2},"king":false,"team":"BLACK"},{"location":{"x":1,"y":5},"king":false,"team":"RED"},{"location":{"x":3,"y":5},"king":false,"team":"RED"},{"location":{"x":5,"y":5},"king":false,"team":"RED"},{"location":{"x":7,"y":5},"king":false,"team":"RED"},{"location":{"x":2,"y":6},"king":false,"team":"RED"},{"location":{"x":4,"y":6},"king":false,"team":"RED"},{"location":{"x":6,"y":6},"king":false,"team":"RED"},{"location":{"x":8,"y":6},"king":false,"team":"RED"},{"location":{"x":1,"y":7},"king":false,"team":"RED"},{"location":{"x":3,"y":7},"king":false,"team":"RED"},{"location":{"x":5,"y":7},"king":false,"team":"RED"},{"location":{"x":7,"y":7},"king":false,"team":"RED"}]}}
