package es.ucm.fdi.porras.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="porra")
public class Porra implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="external_id", length = 255, nullable = false)
    private String externalId;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", length = 1024)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "valid")
    private Boolean valid;

    @Column(name = "winner_bet", length = 255)
    private String winerBet;

    @Column(name = "winner_possible_bet")
    private Integer winnerPosisibleBet;

    @Column(name = "max_participants")
    private Integer maxParticipantes;

    @Column(name = "finish_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishTime;

    @Column(name = "type")
    private String type;

    @Column(name = "visits")
    private Long visits;

    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY)
    private List<PossibleBet> possibleBets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getWinerBet() {
        return winerBet;
    }

    public void setWinerBet(String winerBet) {
        this.winerBet = winerBet;
    }

    public Integer getWinnerPosisibleBet() {
        return winnerPosisibleBet;
    }

    public void setWinnerPosisibleBet(Integer winnerPosisibleBet) {
        this.winnerPosisibleBet = winnerPosisibleBet;
    }

    public Integer getMaxParticipantes() {
        return maxParticipantes;
    }

    public void setMaxParticipantes(Integer maxParticipantes) {
        this.maxParticipantes = maxParticipantes;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getVisits() {
        return visits;
    }

    public void setVisits(Long visits) {
        this.visits = visits;
    }

    public List<PossibleBet> getPossibleBets() {
        return possibleBets;
    }

    public void setPossibleBets(List<PossibleBet> possibleBets) {
        this.possibleBets = possibleBets;
    }
}
