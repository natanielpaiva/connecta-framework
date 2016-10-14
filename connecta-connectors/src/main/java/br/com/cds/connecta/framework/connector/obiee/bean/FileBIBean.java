package br.com.cds.connecta.framework.connector.obiee.bean;


/**
 *
 * @author jhonatas
 */
public class FileBIBean {

    public enum Type {
        folder, link, object, noaccess, unknow
    }

    private String name;
    private String path;
    private Type type;

    public FileBIBean() {
        this.name = new String();
        this.path = new String();
        this.type = Type.unknow;
    }

    public FileBIBean(String name, String path, Type type) {
        this.name = name;
        this.path = path;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

}
