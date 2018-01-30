package gov.usgs.wim.wdnr.transform;

public interface ITransformer extends AutoCloseable {

    void write(Object object);

    void end();

}