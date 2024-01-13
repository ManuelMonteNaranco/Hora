public class Hora {
    private int hora;
    private int minutos;
    private int segundos;


    public Hora(int hora, int minutos, int segundos) {
        this.hora = hora;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }

    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }

    public int aSegundos() {
        return this.hora * 3600 + this.minutos * 60 + this.segundos;
    }

    public void avanzarSegundos() {
        if (this.segundos == 59) {
            this.segundos = 0;
            this.minutos++;
            if (this.minutos == 59) {
                this.minutos = 0;
                this.hora++;
                if (this.hora == 23) {
                    this.hora = 0;
                } else {
                    this.hora++;
                }
            } else {
                this.minutos++;
            }
        } else {
            this.segundos++;
        }
    }

    public void atrasSegundos() {
        if (this.segundos == 0) {
            this.segundos = 59;

            if (this.minutos == 0) {
                this.minutos = 59;

                if (this.hora == 0) {
                    this.hora = 23;

                } else {
                    this.hora--;
                }

            } else {
                this.minutos--;
            }
        } else {
            this.segundos--;
        }

    }


    public String toString() {
        //if (this.hora < 10 && this.minutos < 10 && this.segundos < 10) {
        //  return "0" + this.hora + ":" + "0" + this.minutos + ":" + "0" + this.segundos;
        //}
        //return this.hora + ":" + this.minutos + ":" + this.segundos;

        StringBuilder resultado = new StringBuilder();
        resultado.append(String.format("%02d:%02d:%02d", this.hora, this.minutos, this.segundos));
        return resultado.toString();

    }

    public String toStringConIf() {
        StringBuilder resultado = new StringBuilder();
        resultado.append(rellenarConCeros(this.hora));
        resultado.append(":");
        resultado.append(rellenarConCeros(this.minutos));
        resultado.append(":");
        resultado.append(rellenarConCeros(this.segundos));
        resultado.append(":");

        return resultado.toString();
    }

    private String rellenarConCeros(int cantidad) {
        StringBuilder resultado = new StringBuilder();
        if (cantidad < 10) {
            resultado.append("0");
        }
        resultado.append(cantidad);
        return resultado.toString();
    }

    public String enFormatoAmPm() {
        String hora = "";
        int am = 0;
        if (this.hora > 12) {
            am = this.hora - 12;
            hora = "Pm";
            }else {
            am = this.hora;
            hora = "Am";
        }
        StringBuilder sb = new StringBuilder();

        sb.append( String.format("%02d : %02d :%02d  se devuelve como %02d:%02d:%02d %s", this.hora, this.minutos , this.segundos, am, this.minutos, this.segundos, hora));
        return sb.toString();
    }
}

