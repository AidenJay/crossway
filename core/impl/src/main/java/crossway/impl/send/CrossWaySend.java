package crossway.impl.send;

import crossway.config.SenderConfig;
import crossway.core.request.CrossWayRequest;
import crossway.core.response.CrossWayResponse;
import crossway.exception.CrossWayException;
import crossway.ext.api.Extension;
import crossway.send.Send;

/**
 * description:
 *
 * @author: Johnson Wang
 * @date: 2020/7/3 16:59
 * @copyright: 2020, FA Software (Shanghai) Co., Ltd. All Rights Reserved.
 */
@Extension("default-send")
public class CrossWaySend extends Send {

    private CrossWaySendEvent sendEvent;

    public CrossWaySend(SenderConfig senderConfig) {
        super(senderConfig);
    }

    @Override
    public CrossWayResponse invoke(CrossWayRequest request) throws CrossWayException {
        CrossWayResponse response = new CrossWayResponse();

        if (sendEvent != null) {
            sendEvent.event(request);
        }

        return response;
    }

    public void setSendEvent(CrossWaySendEvent sendEvent) {
        this.sendEvent = sendEvent;
    }
}