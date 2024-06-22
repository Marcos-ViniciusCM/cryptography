package br.com.marcos.model;

import br.com.marcos.service.CryptoService;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String encryptedUserDocument;
	@Column
	private String encryptedCreditCardToken;
	@Column
	private Long value;
	
	
	@Transient
	private  String rawcreditCardToken;
	
	@Transient
	private String rawuserDocument;

	
	
	
	public User(Long id, String encryptedUserDocument, String encryptedCreditCardToken, Long value,
			String rawcreditCardToken, String rawuserDocument) {
		this.id = id;
		this.encryptedUserDocument = encryptedUserDocument;
		this.encryptedCreditCardToken = encryptedCreditCardToken;
		this.value = value;
		this.rawcreditCardToken = rawcreditCardToken;
		this.rawuserDocument = rawuserDocument;
	}




	public User() {
	}

	



	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getEncryptedUserDocument() {
		return encryptedUserDocument;
	}




	public void setEncryptedUserDocument(String encryptedUserDocument) {
		this.encryptedUserDocument = encryptedUserDocument;
	}




	public String getEncryptedCreditCardToken() {
		return encryptedCreditCardToken;
	}




	public void setEncryptedCreditCardToken(String encryptedCreditCardToken) {
		this.encryptedCreditCardToken = encryptedCreditCardToken;
	}




	public Long getValue() {
		return value;
	}




	public void setValue(Long value) {
		this.value = value;
	}




	public String getRawcreditCardToken() {
		return rawcreditCardToken;
	}




	public void setRawcreditCardToken(String rawcreditCardToken) {
		this.rawcreditCardToken = rawcreditCardToken;
	}




	public String getRawuserDocument() {
		return rawuserDocument;
	}




	public void setRawuserDocument(String rawuserDocument) {
		this.rawuserDocument = rawuserDocument;
	}




	@PrePersist
	public void prePersist() {
		this.encryptedUserDocument = CryptoService.encryptText(rawuserDocument);
		this.encryptedCreditCardToken = CryptoService.encryptText(rawcreditCardToken);
	}
	
	@PostLoad
	public void postLoad() {
		this.rawuserDocument = CryptoService.decrypt(encryptedUserDocument);
		this.rawcreditCardToken = CryptoService.decrypt(encryptedCreditCardToken);
	}
		
	}
	

