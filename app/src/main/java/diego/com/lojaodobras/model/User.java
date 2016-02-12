package diego.com.lojaodobras.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Diegopc on 11/02/2016.
 */

public class User {

    private String idUser;
    private String nome;
    private String sobrenome;
    private String dataNascimento;
    private String email;
    private String cpf;
    private String sexo;
    private String urlFoto;
    private String password;
    private String idSocial;
    private String latitude;
    private String longitude;
    private String device;
    private String token;

    public String getId() {
        return idUser;
    }

    public void setId(String idUser) {
        this.idUser = idUser;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdSocial() {
        return idSocial;
    }

    public void setIdSocial(String idSocial) {
        this.idSocial = idSocial;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }




    public static User userToJson(JSONObject jsonObject){

        User user = new User();

        try {
            JSONObject usuario = jsonObject.getJSONObject("usuario");

            user.setId(usuario.optString("id"));
            user.setNome(usuario.optString("nome"));
            user.setSobrenome(usuario.optString("sobrenome"));
            user.setDataNascimento(usuario.optString("dataNascimento"));
            user.setEmail(usuario.optString("email"));
            user.setCpf(usuario.optString("cpf"));
            user.setSexo(usuario.optString("sexo"));
            user.setUrlFoto(usuario.optString("urlFoto"));
            user.setPassword(usuario.optString("password"));
            user.setIdSocial(usuario.optString("idSocial"));
            user.setLatitude(usuario.optString("latitude"));
            user.setLongitude(usuario.optString("longitude"));
            user.setDevice(usuario.optString("tipoDevice"));
            user.setToken(usuario.optString("token"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }









}
