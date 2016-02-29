/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Man;
import java.util.List;

/**
 *
 * @author Alexey
 */
public interface ManDAO {
   List<Man> listAllMans();
    Man getManById(Integer manId);
    int addMan(Man man);
    boolean editMan(Man man);
    boolean deleteMan(Man man);
}
