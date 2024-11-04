package com.github.txmy.wrapper.modules;

import java.util.UUID;


public interface BorderModule<T, J> {

    void displayBorder(T player, J border) ;
    void resetBorder(T player, String border) ;
    void resetBorders(T player) ;
    void displayBorder(UUID uniqueId, J border) ;
    void resetBorder(UUID uniqueId, String border) ;
    void resetBorders(UUID uniqueId) ;

    void displayBorder(J border);
    void resetBorders();
    void resetBorder(String border);
}
