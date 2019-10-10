package com.company;

public interface MenuState {
    void next(Menu menu);
    void previous(Menu menu);
    void printState();
}
