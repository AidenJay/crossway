package crossway.impl.codec.node;

import crossway.codec.node.Node;

import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class ContainerNode<T extends ContainerNode<T>> extends BaseNode implements NodeCreator {
    private static final long serialVersionUID = 1L;

    /**
     * We will keep a reference to the Object (usually TreeMapper) that can construct instances of nodes to add to this
     * container node.
     */
    protected final NodeFactory _nodeFactory;

    protected ContainerNode(NodeFactory nc) {
        _nodeFactory = nc;
    }

    protected ContainerNode() {
        _nodeFactory = null;
    } // only for JDK ser

    // all containers are mutable: can't define:
    //    @Override public abstract <T extends JsonNode> T deepCopy();

    @Override
    public String asText() {
        return "";
    }

    /*
    /**********************************************************
    /* Methods reset as abstract to force real implementation
    /**********************************************************
     */

    @Override
    public abstract int size();

    @Override
    public abstract Node get(int index);

    @Override
    public abstract Node get(String fieldName);

    /*
    /**********************************************************
    /* NodeCreator implementation, Enumerated/singleton types
    /**********************************************************
     */

    @Override
    public final BooleanNode booleanNode(boolean v) {
        return _nodeFactory.booleanNode(v);
    }

    public Node missingNode() {
        return _nodeFactory.missingNode();
    }

    @Override
    public final NullNode nullNode() {
        return _nodeFactory.nullNode();
    }

    /*
    /**********************************************************
    /* NodeCreator implementation, just dispatch to real creator
    /**********************************************************
     */

    @Override
    public final ArrayNode arrayNode() {
        return _nodeFactory.arrayNode();
    }

    /**
     * Factory method that constructs and returns an {@link ArrayNode} with an initial capacity Construction is done
     * using registered {@link NodeFactory}
     *
     * @param capacity
     *     the initial capacity of the ArrayNode
     */
    @Override
    public final ArrayNode arrayNode(int capacity) {
        return _nodeFactory.arrayNode(capacity);
    }

    /**
     * Factory method that constructs and returns an empty {@link ObjectNode} Construction is done using registered
     * {@link NodeFactory}.
     */
    @Override
    public final ObjectNode objectNode() {
        return _nodeFactory.objectNode();
    }

    @Override
    public final ValueNode numberNode(byte v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final NumericNode numberNode(short v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final NumericNode numberNode(int v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final NumericNode numberNode(long v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final NumericNode numberNode(float v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final NumericNode numberNode(double v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final ValueNode numberNode(BigInteger v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final ValueNode numberNode(BigDecimal v) {
        return (_nodeFactory.numberNode(v));
    }

    @Override
    public final ValueNode numberNode(Byte v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final ValueNode numberNode(Short v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final ValueNode numberNode(Integer v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final ValueNode numberNode(Long v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final ValueNode numberNode(Float v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final ValueNode numberNode(Double v) {
        return _nodeFactory.numberNode(v);
    }

    @Override
    public final TextNode textNode(String text) {
        return _nodeFactory.textNode(text);
    }

    @Override
    public final ValueNode pojoNode(Object pojo) {
        return _nodeFactory.pojoNode(pojo);
    }

    @Override
    public final BinaryNode binaryNode(byte[] data) {
        return _nodeFactory.binaryNode(data);
    }

    @Override
    public final BinaryNode binaryNode(byte[] data, int offset, int length) {
        return _nodeFactory.binaryNode(data, offset, length);
    }


    /*
    /**********************************************************
    /* Common mutators
    /**********************************************************
     */

    /**
     * Method for removing all children container has (if any)
     *
     * @return Container node itself (to allow method call chaining)
     */
    public abstract T removeAll();
}
