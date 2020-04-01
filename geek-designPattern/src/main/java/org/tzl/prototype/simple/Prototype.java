package org.tzl.prototype.simple;

public class Prototype implements Cloneable {

    private String name;


    private CloneTarget cloneTarget;


    public CloneTarget getCloneTarget() {
        return cloneTarget;
    }

    public void setCloneTarget(CloneTarget cloneTarget) {
        this.cloneTarget = cloneTarget;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
