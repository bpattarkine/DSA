import java.util.ArrayList;

public class ResourcePoolImpl extends ResourcePool {

  ResourcePoolImpl(int size) {
    super(size);
    resources = new ArrayList<>(size);
    for (int i = 0; i < this.size; ++i) {
    resources.add(new Resource());

    }
  }

  @Override
  public Resource ClaimResource() {
    if (!resources.isEmpty()) {
    System.out.println( "resource cliamed");
      return resources.remove(0);

    }

    System.out.println("no more resources claim");
    return null;
  }

  @Override
  public void ReleaseResource(Resource resource) {
   if (resources.size() < this.size && resource != null) {
     resources.add(resource);

      System.out.println("released resource aded back to pool");
   } else {
   System.out.println("no more space to release resource;");
   }

  }
}
