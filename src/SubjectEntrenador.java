public interface SubjectEntrenador {
    public void notifica(String missatge);
    public void donaAlta(ObserverEntrenador o);
    public void donaBaixa(ObserverEntrenador o);
}
