package com.mercury.platform.core.utils.interceptor;

import com.mercury.platform.core.utils.interceptor.filter.MessageFilter;
import com.mercury.platform.shared.store.MercuryStoreCore;
import org.apache.commons.lang3.StringUtils;

public class PlayerJoinInterceptor extends MessageInterceptor {
    @Override
    protected void process(String message) {
        MercuryStoreCore.playerJoinSubject.onNext(StringUtils.substringBetween(message," : ", " has joined the area."));
    }

    @Override
    protected MessageFilter getFilter() {
        return message -> message.contains("has joined the area.");
    }
}
