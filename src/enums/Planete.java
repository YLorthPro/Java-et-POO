package enums;

public enum Planete {
    MERCURE(3.285e23, 57.91),
    VENUS(4.867e24, 108.2),
    TERRE(5.972e24, 149.6),
    MARS(6.39e23, 227.9),
    JUPITER(1.898e27, 778.5),
    SATURNE(5.683e26, 1433.5),
    URANUS(8.681e25, 2872.5),
    NEPTUNE(1.024e26, 4495.1);

    private double masse; // en kg
    private double distanceAuSoleil; // en millions de kilomètres

    Planete(double masse, double distanceAuSoleil) {
        this.masse = masse;
        this.distanceAuSoleil = distanceAuSoleil;
    }

    public double getMasse() {
        return masse;
    }

    public double getDistanceAuSoleil() {
        return distanceAuSoleil;
    }
}
