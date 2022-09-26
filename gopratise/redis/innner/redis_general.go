package innner

import "github.com/go-redis/redis"

const RedisHost = "192.168.1.5:6379"

func InitRedisCli() *redis.Client {
	return redis.NewClient(&redis.Options{
		Addr: RedisHost,
	})
}
