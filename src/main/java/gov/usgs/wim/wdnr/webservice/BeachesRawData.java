package gov.usgs.wim.wdnr.webservice;

import java.math.BigInteger;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Length;

@UniqueKey
public class BeachesRawData {
    private BigInteger id;

    @Length(min=0, max=50)
    private String userName;

    @Length(min=0, max=10)
    private String userId;

    @Length(min=0, max=50)
    private String favorites;

    @Length(min=0, max=50)
    private String county;

    @Length(min=0, max=50)
    private String lake;

    @Length(min=0, max=50)
    private String beach;

    @Length(min=0, max=10)
    private String beachSeq;

    @Length(min=0, max=50)
    private String site;

    @Length(min=0, max=10)
    private String monitorSiteSeq;

    @Length(min=0, max=50)
    private String ecoliSampleType;

    @Length(min=0, max=50)
    private String sampleDateTimeDisplayed;

    @Length(min=0, max=50)
    private String sampleDateTime;

    @Length(min=0, max=5)
    private String noGulls;

    @Length(min=0, max=5)
    private String noGeese;

    @Length(min=0, max=5)
    private String noDogs;

    @Length(min=0, max=5)
    private String noAnimalsOther;

    @Length(min=0, max=50)
    private String noAnimalsOtherDesc;

    @Length(min=0, max=5)
    private String numLoons;

    @Length(min=0, max=5)
    private String numHerrGulls;

    @Length(min=0, max=5)
    private String numRingGulls;

    @Length(min=0, max=5)
    private String numCormorants;

    @Length(min=0, max=5)
    private String numLongtailDucks;

    @Length(min=0, max=5)
    private String numScoter;

    @Length(min=0, max=5)
    private String numHornGrebe;

    @Length(min=0, max=5)
    private String numRedneckedGrebe;

    @Length(min=0, max=5)
    private String numFish;

    @Length(min=0, max=5)
    private String numOther;

    @Length(min=0, max=50)
    private String numOtherDesc;

    @Length(min=0, max=5)
    private String floatStreetLitter;

    @Length(min=0, max=5)
    private String floatFood;

    @Length(min=0, max=5)
    private String floatMedical;

    @Length(min=0, max=5)
    private String floatSewage;

    @Length(min=0, max=5)
    private String floatBldgMaterials;

    @Length(min=0, max=5)
    private String floatFishing;

    @Length(min=0, max=5)
    private String floatOther;

    @Length(min=0, max=5)
    private String floatOtherDesc;

    @Length(min=0, max=5)
    private String debrisStreetLitter;

    @Length(min=0, max=5)
    private String debrisFood;

    @Length(min=0, max=5)
    private String debrisMedical;

    @Length(min=0, max=5)
    private String debrisSewage;

    @Length(min=0, max=5)
    private String debrisBldgMaterials;

    @Length(min=0, max=5)
    private String debrisFishing;

    @Length(min=0, max=5)
    private String debrisHousehold;

    @Length(min=0, max=5)
    private String debrisTar;

    @Length(min=0, max=5)
    private String debrisOil;

    @Length(min=0, max=5)
    private String debrisOther;

    @Length(min=0, max=50)
    private String debrisOtherDesc;

    @Length(min=0, max=50)
    private String debrisAmount;

    @Length(min=0, max=5)
    private String noInWater;

    @Length(min=0, max=5)
    private String numOutOfWater;

    @Length(min=0, max=5)
    private String noPeopleBoating;

    @Length(min=0, max=5)
    private String noPeopleFishing;

    @Length(min=0, max=5)
    private String noPeopleSurfing;

    @Length(min=0, max=5)
    private String noPeopleWindsurfing;

    @Length(min=0, max=5)
    private String numPeopleDiving;

    @Length(min=0, max=5)
    private String noPeopleClamming;

    @Length(min=0, max=5)
    private String noPeopleOther;

    @Length(min=0, max=50)
    private String noPeopleOtherDesc;

    @Length(min=0, max=5)
    private String airTemp;

    @Length(min=0, max=10)
    private String airUnits;

    @Length(min=0, max=5)
    private String windSpeed;

    @Length(min=0, max=10)
    private String windSpeedUnits;

    @Length(min=0, max=5)
    private String windDirDegrees;

    @Length(min=0, max=50)
    private String windDirDesc;

    @Length(min=0, max=50)
    private String weatherDes;

    @Length(min=0, max=50)
    private String rainfallLastEvent;

    @Length(min=0, max=5)
    private String rainfall;

    @Length(min=0, max=50)
    private String rainfallUnits;

    @Length(min=0, max=50)
    private String rainfallStdDesc;

    @Length(min=0, max=5)
    private String waveHeight;

    @Length(min=0, max=50)
    private String waveHeightUnits;

    @Length(min=0, max=5)
    private String estActFlag;

    @Length(min=0, max=50)
    private String waveDirection;

    @Length(min=0, max=50)
    private String waveConditions;

    @Length(min=0, max=50)
    private String currentSpeed;

    @Length(min=0, max=50)
    private String longshoreCurrentUnits;

    @Length(min=0, max=50)
    private String shorelineCurrentDir;

    @Length(min=0, max=5)
    private String pH;

    @Length(min=0, max=10)
    private String colorChange;

    @Length(min=0, max=50)
    private String colorDescription;

    @Length(min=0, max=50)
    private String odorDescription;

    @Length(min=0, max=50)
    private String odorOtherDescription;

    @Length(min=0, max=5)
    private String avgWaterTemp;

    @Length(min=0, max=10)
    private String avgWaterTempUnits;

    @Length(min=0, max=50)
    private String clarityDesc;

    @Length(min=0, max=50)
    private String NTU;

    @Length(min=0, max=5)
    private String secchiTubeCm;

    @Length(min=0, max=50)
    private String algaeNearShore;

    @Length(min=0, max=50)
    private String algaeOnBeach;

    @Length(min=0, max=5)
    private String algaeTypePeriphyton;

    @Length(min=0, max=5)
    private String algaeTypeGlobular;

    @Length(min=0, max=5)
    private String algaeTypeFreefloating;

    @Length(min=0, max=5)
    private String algaeTypeOther;

    @Length(min=0, max=50)
    private String algaeTypeOtherDesc;

    @Length(min=0, max=5)
    private String algaeColorLtGreen;

    @Length(min=0, max=5)
    private String algaeColorBrightGreen;

    @Length(min=0, max=5)
    private String algaeColorDrkGreen;

    @Length(min=0, max=5)
    private String algaeColorYellow;

    @Length(min=0, max=5)
    private String algaeColorBrown;

    @Length(min=0, max=5)
    private String algaeColorOther;

    @Length(min=0, max=50)
    private String algaeColorOtherDesc;

    @Length(min=0, max=50)
    private String part1Comments;

    @Length(min=0, max=50)
    private String part2Coments;

    @Length(min=0, max=50)
    private String part3Comments;

    @Length(min=0, max=50)
    private String part4Comments;

    @Length(min=0, max=10)
    private String dateEntered;

    @Length(min=0, max=10)
    private String dateUpdated;

    @Length(min=0, max=5)
    private String missingRequiredFlag;

    @Length(min=0, max=50)
    private String vPages;

    @Length(min=0, max=5)
    private String submitted;

    @Length(min=0, max=10)
    private String idNo;

    @Length(min=0, max=10)
    private String date;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setFavorites(String favorites) {
        this.favorites = favorites;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public void setLake(String lake) {
        this.lake = lake;
    }

    public void setBeach(String beach) {
        this.beach = beach;
    }

    public void setBeachSeq(String beachSeq) {
        this.beachSeq = beachSeq;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setMonitorSiteSeq(String monitorSiteSeq) {
        this.monitorSiteSeq = monitorSiteSeq;
    }

    public void setEcoliSampleType(String ecoliSampleType) {
        this.ecoliSampleType = ecoliSampleType;
    }

    public void setSampleDateTimeDisplayed(String sampleDateTimeDisplayed) {
        this.sampleDateTimeDisplayed = sampleDateTimeDisplayed;
    }

    public void setSampleDateTime(String sampleDateTime) {
        this.sampleDateTime = sampleDateTime;
    }

    public void setNoGulls(String noGulls) {
        this.noGulls = noGulls;
    }

    public void setNoGeese(String noGeese) {
        this.noGeese = noGeese;
    }

    public void setNoDogs(String noDogs) {
        this.noDogs = noDogs;
    }

    public void setNoAnimalsOther(String noAnimalsOther) {
        this.noAnimalsOther = noAnimalsOther;
    }

    public void setNoAnimalsOtherDesc(String noAnimalsOtherDesc) {
        this.noAnimalsOtherDesc = noAnimalsOtherDesc;
    }

    public void setNumLoons(String numLoons) {
        this.numLoons = numLoons;
    }

    public void setNumHerrGulls(String numHerrGulls) {
        this.numHerrGulls = numHerrGulls;
    }

    public void setNumRingGulls(String numRingGulls) {
        this.numRingGulls = numRingGulls;
    }

    public void setNumCormorants(String numCormorants) {
        this.numCormorants = numCormorants;
    }

    public void setNumLongtailDucks(String numLongtailDucks) {
        this.numLongtailDucks = numLongtailDucks;
    }

    public void setNumScoter(String numScoter) {
        this.numScoter = numScoter;
    }

    public void setNumHornGrebe(String numHornGrebe) {
        this.numHornGrebe = numHornGrebe;
    }

    public void setNumRedneckedGrebe(String numRedneckedGrebe) {
        this.numRedneckedGrebe = numRedneckedGrebe;
    }

    public void setNumFish(String numFish) {
        this.numFish = numFish;
    }

    public void setNumOther(String numOther) {
        this.numOther = numOther;
    }

    public void setNumOtherDesc(String numOtherDesc) {
        this.numOtherDesc = numOtherDesc;
    }

    public void setFloatStreetLitter(String floatStreetLitter) {
        this.floatStreetLitter = floatStreetLitter;
    }

    public void setFloatFood(String floatFood) {
        this.floatFood = floatFood;
    }

    public void setFloatMedical(String floatMedical) {
        this.floatMedical = floatMedical;
    }

    public void setFloatSewage(String floatSewage) {
        this.floatSewage = floatSewage;
    }

    public void setFloatBldgMaterials(String floatBldgMaterials) {
        this.floatBldgMaterials = floatBldgMaterials;
    }

    public void setFloatFishing(String floatFishing) {
        this.floatFishing = floatFishing;
    }

    public void setFloatOther(String floatOther) {
        this.floatOther = floatOther;
    }

    public void setFloatOtherDesc(String floatOtherDesc) {
        this.floatOtherDesc = floatOtherDesc;
    }

    public void setDebrisStreetLitter(String debrisStreetLitter) {
        this.debrisStreetLitter = debrisStreetLitter;
    }

    public void setDebrisFood(String debrisFood) {
        this.debrisFood = debrisFood;
    }

    public void setDebrisMedical(String debrisMedical) {
        this.debrisMedical = debrisMedical;
    }

    public void setDebrisSewage(String debrisSewage) {
        this.debrisSewage = debrisSewage;
    }

    public void setDebrisBldgMaterials(String debrisBldgMaterials) {
        this.debrisBldgMaterials = debrisBldgMaterials;
    }

    public void setDebrisFishing(String debrisFishing) {
        this.debrisFishing = debrisFishing;
    }

    public void setDebrisHousehold(String debrisHousehold) {
        this.debrisHousehold = debrisHousehold;
    }

    public void setDebrisTar(String debrisTar) {
        this.debrisTar = debrisTar;
    }

    public void setDebrisOil(String debrisOil) {
        this.debrisOil = debrisOil;
    }

    public void setDebrisOther(String debrisOther) {
        this.debrisOther = debrisOther;
    }

    public void setDebrisOtherDesc(String debrisOtherDesc) {
        this.debrisOtherDesc = debrisOtherDesc;
    }

    public void setDebrisAmount(String debrisAmount) {
        this.debrisAmount = debrisAmount;
    }

    public void setNoInWater(String noInWater) {
        this.noInWater = noInWater;
    }

    public void setNumOutOfWater(String numOutOfWater) {
        this.numOutOfWater = numOutOfWater;
    }

    public void setNoPeopleBoating(String noPeopleBoating) {
        this.noPeopleBoating = noPeopleBoating;
    }

    public void setNoPeopleFishing(String noPeopleFishing) {
        this.noPeopleFishing = noPeopleFishing;
    }

    public void setNoPeopleSurfing(String noPeopleSurfing) {
        this.noPeopleSurfing = noPeopleSurfing;
    }

    public void setNoPeopleWindsurfing(String noPeopleWindsurfing) {
        this.noPeopleWindsurfing = noPeopleWindsurfing;
    }

    public void setNumPeopleDiving(String numPeopleDiving) {
        this.numPeopleDiving = numPeopleDiving;
    }

    public void setNoPeopleClamming(String noPeopleClamming) {
        this.noPeopleClamming = noPeopleClamming;
    }

    public void setNoPeopleOther(String noPeopleOther) {
        this.noPeopleOther = noPeopleOther;
    }

    public void setNoPeopleOtherDesc(String noPeopleOtherDesc) {
        this.noPeopleOtherDesc = noPeopleOtherDesc;
    }

    public void setAirTemp(String airTemp) {
        this.airTemp = airTemp;
    }

    public void setAirUnits(String airUnits) {
        this.airUnits = airUnits;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindSpeedUnits(String windSpeedUnits) {
        this.windSpeedUnits = windSpeedUnits;
    }

    public void setWindDirDegrees(String windDirDegrees) {
        this.windDirDegrees = windDirDegrees;
    }

    public void setWindDirDesc(String windDirDesc) {
        this.windDirDesc = windDirDesc;
    }

    public void setWeatherDes(String weatherDes) {
        this.weatherDes = weatherDes;
    }

    public void setRainfallLastEvent(String rainfallLastEvent) {
        this.rainfallLastEvent = rainfallLastEvent;
    }

    public void setRainfall(String rainfall) {
        this.rainfall = rainfall;
    }

    public void setRainfallUnits(String rainfallUnits) {
        this.rainfallUnits = rainfallUnits;
    }

    public void setRainfallStdDesc(String rainfallStdDesc) {
        this.rainfallStdDesc = rainfallStdDesc;
    }

    public void setWaveHeight(String waveHeight) {
        this.waveHeight = waveHeight;
    }

    public void setWaveHeightUnits(String waveHeightUnits) {
        this.waveHeightUnits = waveHeightUnits;
    }

    public void setEstActFlag(String estActFlag) {
        this.estActFlag = estActFlag;
    }

    public void setWaveDirection(String waveDirection) {
        this.waveDirection = waveDirection;
    }

    public void setWaveConditions(String waveConditions) {
        this.waveConditions = waveConditions;
    }

    public void setCurrentSpeed(String currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public void setLongshoreCurrentUnits(String longshoreCurrentUnits) {
        this.longshoreCurrentUnits = longshoreCurrentUnits;
    }

    public void setShorelineCurrentDir(String shorelineCurrentDir) {
        this.shorelineCurrentDir = shorelineCurrentDir;
    }

    public void setpH(String pH) {
        this.pH = pH;
    }

    public void setColorChange(String colorChange) {
        this.colorChange = colorChange;
    }

    public void setColorDescription(String colorDescription) {
        this.colorDescription = colorDescription;
    }

    public void setOdorDescription(String odorDescription) {
        this.odorDescription = odorDescription;
    }

    public void setOdorOtherDescription(String odorOtherDescription) {
        this.odorOtherDescription = odorOtherDescription;
    }

    public void setAvgWaterTemp(String avgWaterTemp) {
        this.avgWaterTemp = avgWaterTemp;
    }

    public void setAvgWaterTempUnits(String avgWaterTempUnits) {
        this.avgWaterTempUnits = avgWaterTempUnits;
    }

    public void setClarityDesc(String clarityDesc) {
        this.clarityDesc = clarityDesc;
    }

    public void setNTU(String NTU) {
        this.NTU = NTU;
    }

    public void setSecchiTubeCm(String secchiTubeCm) {
        this.secchiTubeCm = secchiTubeCm;
    }

    public void setAlgaeNearShore(String algaeNearShore) {
        this.algaeNearShore = algaeNearShore;
    }

    public void setAlgaeOnBeach(String algaeOnBeach) {
        this.algaeOnBeach = algaeOnBeach;
    }

    public void setAlgaeTypePeriphyton(String algaeTypePeriphyton) {
        this.algaeTypePeriphyton = algaeTypePeriphyton;
    }

    public void setAlgaeTypeGlobular(String algaeTypeGlobular) {
        this.algaeTypeGlobular = algaeTypeGlobular;
    }

    public void setAlgaeTypeFreefloating(String algaeTypeFreefloating) {
        this.algaeTypeFreefloating = algaeTypeFreefloating;
    }

    public void setAlgaeTypeOther(String algaeTypeOther) {
        this.algaeTypeOther = algaeTypeOther;
    }

    public void setAlgaeTypeOtherDesc(String algaeTypeOtherDesc) {
        this.algaeTypeOtherDesc = algaeTypeOtherDesc;
    }

    public void setAlgaeColorLtGreen(String algaeColorLtGreen) {
        this.algaeColorLtGreen = algaeColorLtGreen;
    }

    public void setAlgaeColorBrightGreen(String algaeColorBrightGreen) {
        this.algaeColorBrightGreen = algaeColorBrightGreen;
    }

    public void setAlgaeColorDrkGreen(String algaeColorDrkGreen) {
        this.algaeColorDrkGreen = algaeColorDrkGreen;
    }

    public void setAlgaeColorYellow(String algaeColorYellow) {
        this.algaeColorYellow = algaeColorYellow;
    }

    public void setAlgaeColorBrown(String algaeColorBrown) {
        this.algaeColorBrown = algaeColorBrown;
    }

    public void setAlgaeColorOther(String algaeColorOther) {
        this.algaeColorOther = algaeColorOther;
    }

    public void setAlgaeColorOtherDesc(String algaeColorOtherDesc) {
        this.algaeColorOtherDesc = algaeColorOtherDesc;
    }

    public void setPart1Comments(String part1Comments) {
        this.part1Comments = part1Comments;
    }

    public void setPart2Coments(String part2Coments) {
        this.part2Coments = part2Coments;
    }

    public void setPart3Comments(String part3Comments) {
        this.part3Comments = part3Comments;
    }

    public void setPart4Comments(String part4Comments) {
        this.part4Comments = part4Comments;
    }

    public void setDateEntered(String dateEntered) {
        this.dateEntered = dateEntered;
    }

    public void setDateUpdated(String dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public void setMissingRequiredFlag(String missingRequiredFlag) {
        this.missingRequiredFlag = missingRequiredFlag;
    }

    public void setvPages(String vPages) {
        this.vPages = vPages;
    }

    public void setSubmitted(String submitted) {
        this.submitted = submitted;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public void setDate(String date) {
        this.date = date;
    }



}
