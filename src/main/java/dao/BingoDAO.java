package dao;

import modelo.Bingo;

/**
 *
 * @author User
 */
public interface BingoDAO {
    
    abstract void modoX();
    abstract void modoCuatroEsquinas();
    abstract void modoCartonLleno();
    abstract void modoZ();
    abstract void EmpezarBingo(Bingo pBingo);
}
