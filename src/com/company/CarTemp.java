package com.company;

public abstract class CarTemp implements Crud{
    public final void buildcar() {
        carvin();
        carnumber();
        carmark();
        carmodel();
        carmileage();
        caryear();
        carcolor();
        carbody();
        carprice();
        newcar();
    }
    public final void redactcar(String vin) {
        //carvin();
        carnumber();
        carmark();
        carmodel();
        carmileage();
        caryear();
        carcolor();
        carbody();
        carprice();
        //newcar();
        redact();
    }

    protected abstract void carvin();
    protected abstract void carnumber();
    protected abstract void carmark();
    protected abstract void carmodel();
    protected abstract void carmileage();
    protected abstract void caryear();
    protected abstract void carcolor();
    protected abstract void carbody();
    protected abstract void carprice();
    protected abstract void newcar();
    protected abstract void redact();

}
