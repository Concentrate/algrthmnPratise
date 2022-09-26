--[[two keys and a value , two account ,one transfer value
  keys[2] = keys[2] + ARGV[1]
  keys[1]=keys[1]-ARGV[1]

  ]]
redis.call("DEL", "log_incr")
local function log(logStr)

    redis.call("RPUSH", "log_incr", logStr)
end

local function logInput(tmpArr)
    for i, v in pairs(tmpArr) do
        log(string.format("%s_%s", i,v))
    end
end

log("start")

logInput(KEYS)
logInput(ARGV)
if #KEYS < 3 or #ARGV < 2 then
    log(string.format("invalid len keys %s,or args %s", #KEYS, #ARGV))
    return -1
end
local account1 = KEYS[2]
local account2 = KEYS[3]
local deduct = ARGV[2]

local balanceFirst = redis.call('GET', account1)

if not balanceFirst then
    print("not found ", account1)
    log(string.format("not found keys %s", account1))
    return -1
end
print(balanceFirst)

if (tonumber(balanceFirst) - tonumber(deduct) <= 0) then
    print("less than 0", balanceFirst, account1)
    log(string.format("less than 0, %s,%s", balanceFirst, account1))
    return -1
end

--redis.call('WATCH', account1, account2)
--redis.call("MULTI")
redis.call("INCRBY", account1, -deduct)
redis.call("INCRBY", account2, deduct)

--local returnValue = redis.call("exec")
--if not returnValue then
--    print("execute ,watch err")
--    log("execute ,watch err")
--    return -1
--else
    return 0
--end