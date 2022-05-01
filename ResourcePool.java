import java.util.List;

public abstract class ResourcePool {

  protected int size;
  protected List<Resource> resources;


  ResourcePool(int size) {
    this.size = size;
  }

  public abstract Resource ClaimResource();

  public abstract void ReleaseResource(Resource resource);


}
