// Interface for Cloud Hosting Provider
interface CloudHostingProvider {
    void createServer(String region);
    void listServers(String region);
}

// Interface for CDN Provider
interface CDNProvider {
    void getCDNAddress();
}

// Interface for Cloud Storage Provider
interface CloudStorageProvider {
    void storeFile(String name);
    void getFile(String name);
}

// Amazon class implements all three interfaces
class Amazon implements CloudHostingProvider, CDNProvider, CloudStorageProvider {
    @Override
    public void createServer(String region) {
        System.out.println("Amazon creating server in " + region);
    }

    @Override
    public void listServers(String region) {
        System.out.println("Amazon listing servers in " + region);
    }

    @Override
    public void getCDNAddress() {
        System.out.println("Amazon providing CDN address");
    }

    @Override
    public void storeFile(String name) {
        System.out.println("Amazon storing file: " + name);
    }

    @Override
    public void getFile(String name) {
        System.out.println("Amazon retrieving file: " + name);
    }
}

// Dropbox implements only CloudStorageProvider
class Dropbox implements CloudStorageProvider {
    @Override
    public void storeFile(String name) {
        System.out.println("Dropbox storing file: " + name);
    }

    @Override
    public void getFile(String name) {
        System.out.println("Dropbox retrieving file: " + name);
    }
}

public class MainFig1 {
    public static void main(String[] args) {
        Amazon amazon = new Amazon();
        amazon.createServer("Asia");
        amazon.listServers("Asia");
        amazon.getCDNAddress();
        amazon.storeFile("project.zip");
        amazon.getFile("project.zip");

        Dropbox dropbox = new Dropbox();
        dropbox.storeFile("photo.jpg");
        dropbox.getFile("photo.jpg");
    }
}
