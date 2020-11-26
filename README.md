# spring-redis-example
A Spring data and Redis CRUD example 
https://github.com/rahimkhanabdul/spring-redis-example


### REDIS Installation Ubuntu

1. Start by updating the package repository:
```bash
sudo apt update
```
2. Then, install Redis with the command:
```bash
sudo apt install redis-server
```
3. Check the status of the Redis service by running the command:
```bash
sudo systemctl status redis
```
4. Check Redis Connection
```bash
redis-cli
ping
```
- The output should respond with:
```bash
PONG
```

### Jedis
Jedis is a blazingly small and sane Redis java client.
##### maven dependency
```xml
<!-- https://mvnrepository.com/artifact/redis.clients/jedis -->
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>3.3.0</version>
    <type>jar</type>
    <scope>compile</scope>
</dependency>
```

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.
