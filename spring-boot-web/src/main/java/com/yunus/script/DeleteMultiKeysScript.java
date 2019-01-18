package com.yunus.script;

import org.springframework.data.redis.core.script.DefaultRedisScript;

/**
 * @author lanxum
 */
public class DeleteMultiKeysScript extends DefaultRedisScript {

    private String pattern;

    public DeleteMultiKeysScript(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getScriptAsString() {
        StringBuffer lua = new StringBuffer("local keys=redis.call('keys',");
        lua.append("'" + pattern + "'" + ")");
        lua.append(" for k,v in pairs(keys) do redis.call('del',v) print(v) end return table.getn(keys)");
        return lua.toString();
    }

    @Override
    public Class<Long> getResultType() {
        return Long.class;
    }
}
