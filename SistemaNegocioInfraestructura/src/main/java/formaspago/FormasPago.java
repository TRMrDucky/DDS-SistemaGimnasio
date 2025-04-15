/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package formaspago;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author 52644
 */
public class FormasPago {

    private static FormasPago formasPago;
    List<Tarjeta> tarjetas;
    List<Paypal> paypals;

    private FormasPago() {
        this.tarjetas = new LinkedList<>();
        this.tarjetas.add(new Tarjeta("José Reynaga", "6458151236482164", 037, 1126, 7000));
        this.tarjetas.add(new Tarjeta("Ramón Zamudio", "16435846798643156", 198, 0725, 7000));
        this.tarjetas.add(new Tarjeta("Eduardo Aguilar", "4875112487623548", 543, 0731, 7000));
        this.tarjetas.add(new Tarjeta("Janeth Galván", "48715332056997456", 168, 1229, 7000));

        this.paypals = new LinkedList<>();
    }

    public FormasPago getFormasPago() {
        if (formasPago == null) {
            formasPago = new FormasPago();
        }
        return formasPago;
    }

    public List<Tarjeta> obtenerTarjetas() {
        return this.tarjetas;
    }

    public List<Paypal> obtenerPaypals() {
        return this.paypals;
    }
}
