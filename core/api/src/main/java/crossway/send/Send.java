package crossway.send;

import crossway.config.SenderConfig;
import crossway.ext.api.Extensible;
import crossway.invoke.Invoker;
import crossway.utils.StringUtils;

import java.util.UUID;

/**
 * @author iamcyw
 **/
@Extensible(singleton = false)
public abstract class Send implements Invoker {

    private final SenderConfig senderConfig;

    private final int id = UUID.randomUUID().hashCode();

    protected Send(SenderConfig senderConfig) {
        this.senderConfig = senderConfig;
    }

    public SenderConfig getConfig() {
        return senderConfig;
    }

    protected String getSeriallzerType() {
        return StringUtils.isNotEmpty(getConfig().getSerializerType()) ? getConfig().getSerializerType() :
               getDefaultSeriallzerType();
    }

    protected abstract String getDefaultSeriallzerType();

    public int getId() {
        return id;
    }
}
