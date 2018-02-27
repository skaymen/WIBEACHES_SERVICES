package gov.usgs.wim.wdnr.domain;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.Length;
import org.springframework.cglib.core.Local;

//@UniqueKey //TODO MONITOR_SITE_SEQ and SAMPLE_DATE_TIME must be unique

//@Parent //TODO UPDATE_ENTRY_SEQ, DATA_ENTRY_SEQ, ANALYZER_SEQ, SAMPLER_SEQ
@JsonIgnoreProperties(ignoreUnknown = true)
public class SanitaryData {

    private String id; //probably what we will use for primary key

    @JsonAlias("user_name") //?
    @Length(min=0, max=50)
    private String userName;

    @JsonAlias("user_id") //?
    @Digits(integer=10, fraction=0)
    private String userId;

    @JsonAlias("__favorites") //?
    @Length(min=0, max=50)
    private String favorites;

    @JsonAlias("__county") //?
    @Length(min=0, max=50)
    private String county;

    @JsonAlias("__lake") //?
    @Length(min=0, max=50)
    private String lake;

    @JsonAlias("__beach") //?
    @Length(min=0, max=50)
    private String beach;

    @JsonAlias("BEACH_SEQ")
    @Digits(integer=8, fraction=0)
    @NotNull
    private String beachSeq;

    @JsonAlias("__site") //?
    @Length(min=0, max=50)
    private String site;

    @JsonAlias("MONITOR_SITE_SEQ")
    @Digits(integer=8, fraction=0)
    private String monitorSiteSeq;

    @JsonAlias("ECOLI_SAMPLE_TYPE")
    @Length(min=0, max=30)
    private String ecoliSampleType;

    @JsonAlias("SAMPLE_DATE_TIME_DISPLAYED") //?
    @Length(min=0, max=50)
    private String sampleDateTimeDisplayed;

    @JsonAlias("SAMPLE_DATE_TIME")
//    @Temporal(TemporalType.DATE) //TODO: Fix this
    @NotNull
    private LocalDateTime sampleDateTime;

    @JsonAlias("NO_GULLS")
    @Digits(integer=8, fraction=0)
    private String noGulls;

    @JsonAlias("NO_GEESE")
    @Digits(integer=8, fraction=0)
    private String noGeese;

    @JsonAlias("NO_DOGS")
    @Digits(integer=8, fraction=0)
    private String noDogs;

    @JsonAlias("NO_ANIMALS_OTHER")
    @Digits(integer=8, fraction=0)
    private String noAnimalsOther;

    @JsonAlias("NO_ANIMALS_OTHER_DESC") //??
    @Length(min=0, max=50)
    private String noAnimalsOtherDesc;

    @JsonAlias("NUM_LOONS")
    @Digits(integer=8, fraction=0)
    private String numLoons;

    @JsonAlias("NUM_HERR_GULLS")
    @Digits(integer=8, fraction=0)
    private String numHerrGulls;

    @JsonAlias("NUM_RING_GULLS")
    @Digits(integer=8, fraction=0)
    private String numRingGulls;

    @JsonAlias("NUM_CORMORANTS")
    @Digits(integer=8, fraction=0)
    private String numCormorants;

    @JsonAlias("NUM_LONGTAIL_DUCKS")
    @Digits(integer=8, fraction=0)
    private String numLongtailDucks;

    @JsonAlias("NUM_SCOTER")
    @Digits(integer=8, fraction=0)
    private String numScoter;

    @JsonAlias("NUM_HORN_GREBE")
    @Digits(integer=8, fraction=0)
    private String numHornGrebe;

    @JsonAlias("NUM_REDNECKED_GREBE")
    @Digits(integer=8, fraction=0)
    private String numRedneckedGrebe;

    @JsonAlias("NUM_FISH") //???
    @Digits(integer=8, fraction=0)
    private String numFish;

    @JsonAlias("NUM_OTHER")
    @Digits(integer=8, fraction=0)
    private String numOther;

    @JsonAlias("NUM_OTHER_DESC")
    @Length(min=0, max=50)
    private String numOtherDesc;

    @JsonAlias("FLOAT_STREET_LITTER")
    @Length(min=0, max=1)
    private String floatStreetLitter;

    @JsonAlias("FLOAT_FOOD")
    @Length(min=0, max=1)
    private String floatFood;

    @JsonAlias("FLOAT_MEDICAL")
    @Length(min=0, max=1)
    private String floatMedical;

    @JsonAlias("FLOAT_SEWAGE")
    @Length(min=0, max=1)
    private String floatSewage;

    @JsonAlias("FLOAT_BLDG_MATERIALS")
    @Length(min=0, max=1)
    private String floatBldgMaterials;

    @JsonAlias("FLOAT_FISHING")
    @Length(min=0, max=1)
    private String floatFishing;

    @JsonAlias("FLOAT_OTHER")
    @Length(min=0, max=1)
    private String floatOther;

    @JsonAlias("FLOAT_OTHER_DESC")
    @Length(min=0, max=50)
    private String floatOtherDesc;

    @JsonAlias("DEBRIS_STREET_LITTER")
    @Length(min=0, max=1)
    private String debrisStreetLitter;

    @JsonAlias("DEBRIS_FOOD")
    @Length(min=0, max=1)
    private String debrisFood;

    @JsonAlias("DEBRIS_MEDICAL")
    @Length(min=0, max=1)
    private String debrisMedical;

    @JsonAlias("DEBRIS_SEWAGE")
    @Length(min=0, max=1)
    private String debrisSewage;

    @JsonAlias("DEBRIS_BLDG_MATERIALS")
    @Length(min=0, max=1)
    private String debrisBldgMaterials;

    @JsonAlias("DEBRIS_FISHING")
    @Length(min=0, max=1)
    private String debrisFishing;

    @JsonAlias("DEBRIS_HOUSEHOLD")
    @Length(min=0, max=1)
    private String debrisHousehold;

    @JsonAlias("DEBRIS_TAR")
    @Length(min=0, max=1)
    private String debrisTar;

    @JsonAlias("DEBRIS_OIL")
    @Length(min=0, max=1)
    private String debrisOil;

    @JsonAlias("DEBRIS_OTHER")
    @Length(min=0, max=1)
    private String debrisOther;

    @JsonAlias("DEBRIS_OTHER_DESC")
    @Length(min=0, max=255)
    private String debrisOtherDesc;

    @JsonAlias("DEBRIS_AMOUNT")
    @Length(min=0, max=30)
    private String debrisAmount;

    @JsonAlias("NO_IN_WATER")
    @Digits(integer=8, fraction=0)
    private String noInWater;

    @JsonAlias("NUM_OUT_OF_WATER")
    @Digits(integer=8, fraction=0)
    private String numOutOfWater;

    @JsonAlias("NO_PEOPLE_BOATING")
    @Digits(integer=8, fraction=0)
    private String noPeopleBoating;

    @JsonAlias("NO_PEOPLE_FISHING")
    @Digits(integer=8, fraction=0)
    private String noPeopleFishing;

    @JsonAlias("NO_PEOPLE_SURFING")
    @Digits(integer=8, fraction=0)
    private String noPeopleSurfing;

    @JsonAlias("NO_PEOPLE_WINDSURFING")
    @Digits(integer=8, fraction=0)
    private String noPeopleWindsurfing;

    @JsonAlias("NUM_PEOPLE_DIVING")
    @Digits(integer=8, fraction=0)
    private String numPeopleDiving;

    @JsonAlias("NO_PEOPLE_CLAMMING")
    @Digits(integer=8, fraction=0)
    private String noPeopleClamming;

    @JsonAlias("NO_PEOPLE_OTHER")
    @Digits(integer=8, fraction=0)
    private String noPeopleOther;

    @JsonAlias("NO_PEOPLE_OTHER_DESC")
    @Length(min=0, max=50)
    private String noPeopleOtherDesc;

    @JsonAlias("AIR_TEMP")
    @Digits(integer=8, fraction=4)
    private String airTemp;

    @JsonAlias("AIR_UNITS")
    @Length(min=0, max=1)
    private String airUnits;

    @JsonAlias("WIND_SPEED")
    @Digits(integer=8, fraction=4)
    private String windSpeed;

    @JsonAlias("WIND_SPEED_UNITS")
    @Length(min=0, max=30)
    private String windSpeedUnits;

    @JsonAlias("WIND_DIR_DEGREES")
    @Digits(integer=8, fraction=0)
    private String windDirDegrees;

    @JsonAlias("WIND_DIR_DESC")
    @Length(min=0, max=30)
    private String windDirDesc;

    @JsonAlias("WEATHER_DES") ///????
    @Length(min=0, max=30)
    private String weatherDes;

    @JsonAlias("RAINFALL_LAST_EVENT")
    @Length(min=0, max=5)
    private String rainfallLastEvent;

    @JsonAlias("RAINFALL")
    @Digits(integer=8, fraction=4)
    private String rainfall;

    @JsonAlias("RAINFALL_UNITS")
    @Length(min=0, max=30)
    private String rainfallUnits;

    @JsonAlias("RAINFALL_STD_DESC") ////????
    @Length(min=0, max=60)
    private String rainfallStdDesc;

    @JsonAlias("WAVE_HEIGHT")
    @Digits(integer=8, fraction=4)
    private String waveHeight;

    @JsonAlias("WAVE_HEIGHT_UNITS")
    @Length(min=0, max=30)
    private String waveHeightUnits;

    @JsonAlias("EST_ACT_FLAG")
    @Length(min=0, max=1)
    private String estActFlag;

    @JsonAlias("WAVE_DIRECTION")
    @Length(min=0, max=10)
    private String waveDirection;

    @JsonAlias("WAVE_CONDITIONS")
    @Length(min=0, max=30)
    private String waveConditions;

    @JsonAlias("CURRENT_SPEED")
    @Digits(integer=8, fraction=0)
    private String currentSpeed;

    @JsonAlias("LONGSHORE_CURRENT_UNITS")
    @Length(min=0, max=30)
    private String longshoreCurrentUnits;

    @JsonAlias("SHORELINE_CURRENT_DIR")
    @Length(min=0, max=30)
    private String shorelineCurrentDir;

    @JsonAlias("PH")
    @Digits(integer=5, fraction=2)
    private String pH;

    @JsonAlias("COLOR_CHANGE")
    @Length(min=0, max=1)
    private String colorChange;

    @JsonAlias("COLOR_DESCRIPTION")
    @Length(min=0, max=50)
    private String colorDescription;

    @JsonAlias("ODOR_DESCRIPTION")
    @Length(min=0, max=50)
    private String odorDescription;

    @JsonAlias("ODOR_OTHER_DESCRIPTION")
    @Length(min=0, max=50)
    private String odorOtherDescription;

    @JsonAlias("AVG_WATER_TEMP")
    @Digits(integer=7, fraction=2)
    private String avgWaterTemp;

    @JsonAlias("AVG_WATER_TEMP_UNITS")
    @Length(min=0, max=10)
    private String avgWaterTempUnits;

    @JsonAlias("CLARITY_DESC")
    @Length(min=0, max=30)
    private String clarityDesc;

    @JsonAlias("NTU")
    @Digits(integer=10, fraction=2)
    private String NTU;

    @JsonAlias("SECCHI_TUBE_CM")
    @Digits(integer=8, fraction=0)
    private String secchiTubeCm;

    @JsonAlias("ALGAE_NEARSHORE")
    @Length(min=0, max=30)
    private String algaeNearshore;

    @JsonAlias("ALGAE_ON_BEACH")
    @Length(min=0, max=30)
    private String algaeOnBeach;

    @JsonAlias("ALGAE_TYPE_PERIPHYTON")
    @Length(min=0, max=1)
    private String algaeTypePeriphyton;

    @JsonAlias("ALGAE_TYPE_GLOBULAR")
    @Length(min=0, max=1)
    private String algaeTypeGlobular;

    @JsonAlias("ALGAE_TYPE_FREEFLOATING")
    @Length(min=0, max=1)
    private String algaeTypeFreefloating;

    @JsonAlias("ALGAE_TYPE_OTHER")
    @Length(min=0, max=1)
    private String algaeTypeOther;

    @JsonAlias("ALGAE_TYPE_OTHER_DESC")
    @Length(min=0, max=50)
    private String algaeTypeOtherDesc;

    @JsonAlias("ALGAE_COLOR_LT_GREEN")
    @Length(min=0, max=1)
    private String algaeColorLtGreen;

    @JsonAlias("ALGAE_COLOR_BRGHT_GREEN") ////????
    @Length(min=0, max=1)
    private String algaeColorBrightGreen;

    @JsonAlias("ALGAE_COLOR_DRK_GREEN")
    @Length(min=0, max=1)
    private String algaeColorDrkGreen;

    @JsonAlias("ALGAE_COLOR_YELLOW")
    @Length(min=0, max=1)
    private String algaeColorYellow;

    @JsonAlias("ALGAE_COLOR_BROWN")
    @Length(min=0, max=1)
    private String algaeColorBrown;

    @JsonAlias("ALGAE_COLOR_OTHER")
    @Length(min=0, max=1)
    private String algaeColorOther;

    @JsonAlias("ALGAE_COLOR_OTHER_DESC")
    @Length(min=0, max=50)
    private String algaeColorOtherDesc;

    @JsonAlias("PART_1_COMMENTS")
    @Length(min=0, max=1000) ///???
    private String part1Comments;

    @JsonAlias("PART_2_COMMENTS")
    @Length(min=0, max=1000) ///???
    private String part2Comments;

    @JsonAlias("PART_3_COMMENTS")
    @Length(min=0, max=1000) ///???
    private String part3Comments;

    @JsonAlias("PART_4_COMMENTS")
    @Length(min=0, max=1000) ///???
    private String part4Comments;

    @JsonAlias("DATE_ENTERED")
//    @Basic //TODO
    @NotNull
    private LocalDateTime dateEntered;

    @JsonAlias("DATE_UPDATED")
//    @Basic //TODO
    private LocalDateTime dateUpdated;

    @JsonAlias("MISSING_REQUIRED_FLAG")
    @Length(min=0, max=1)
    private String missingRequiredFlag;

    @JsonAlias("vPages") /////???
    @Length(min=0, max=50)
    private String vPages;

    @JsonAlias("submitted") ///????
    @Length(min=0, max=5)
    private String submitted;

    @JsonAlias("id")
    @Length(min=0, max=10)
    private String idNo;

    @JsonAlias("date")
//    @Basic //TODO
    private LocalDateTime date;

    public void setId(String id) {
        this.id = id;
    }

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

    public void setSampleDateTime(LocalDateTime sampleDateTime) {
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
        this.algaeNearshore = algaeNearShore;
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

    public void setPart2Coments(String part2Comments) {
        this.part2Comments = part2Comments;
    }

    public void setPart3Comments(String part3Comments) {
        this.part3Comments = part3Comments;
    }

    public void setPart4Comments(String part4Comments) {
        this.part4Comments = part4Comments;
    }

    public void setDateEntered(LocalDateTime dateEntered) {
        this.dateEntered = dateEntered;
    }

    public void setDateUpdated(LocalDateTime dateUpdated) {
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

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getId() { return id; }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getFavorites() {
        return favorites;
    }

    public String getCounty() {
        return county;
    }

    public String getLake() {
        return lake;
    }

    public String getBeach() {
        return beach;
    }

    public String getBeachSeq() {
        return beachSeq;
    }

    public String getSite() {
        return site;
    }

    public String getMonitorSiteSeq() {
        return monitorSiteSeq;
    }

    public String getEcoliSampleType() {
        return ecoliSampleType;
    }

    public String getSampleDateTimeDisplayed() {
        return sampleDateTimeDisplayed;
    }

    public LocalDateTime getSampleDateTime() {
        return sampleDateTime;
    }

    public String getNoGulls() {
        return noGulls;
    }

    public String getNoGeese() {
        return noGeese;
    }

    public String getNoDogs() {
        return noDogs;
    }

    public String getNoAnimalsOther() {
        return noAnimalsOther;
    }

    public String getNoAnimalsOtherDesc() {
        return noAnimalsOtherDesc;
    }

    public String getNumLoons() {
        return numLoons;
    }

    public String getNumHerrGulls() {
        return numHerrGulls;
    }

    public String getNumRingGulls() {
        return numRingGulls;
    }

    public String getNumCormorants() {
        return numCormorants;
    }

    public String getNumLongtailDucks() {
        return numLongtailDucks;
    }

    public String getNumScoter() {
        return numScoter;
    }

    public String getNumHornGrebe() {
        return numHornGrebe;
    }

    public String getNumRedneckedGrebe() {
        return numRedneckedGrebe;
    }

    public String getNumFish() {
        return numFish;
    }

    public String getNumOther() {
        return numOther;
    }

    public String getNumOtherDesc() {
        return numOtherDesc;
    }

    public String getFloatStreetLitter() {
        return floatStreetLitter;
    }

    public String getFloatFood() {
        return floatFood;
    }

    public String getFloatMedical() {
        return floatMedical;
    }

    public String getFloatSewage() {
        return floatSewage;
    }

    public String getFloatBldgMaterials() {
        return floatBldgMaterials;
    }

    public String getFloatFishing() {
        return floatFishing;
    }

    public String getFloatOther() {
        return floatOther;
    }

    public String getFloatOtherDesc() {
        return floatOtherDesc;
    }

    public String getDebrisStreetLitter() {
        return debrisStreetLitter;
    }

    public String getDebrisFood() {
        return debrisFood;
    }

    public String getDebrisMedical() {
        return debrisMedical;
    }

    public String getDebrisSewage() {
        return debrisSewage;
    }

    public String getDebrisBldgMaterials() {
        return debrisBldgMaterials;
    }

    public String getDebrisFishing() {
        return debrisFishing;
    }

    public String getDebrisHousehold() {
        return debrisHousehold;
    }

    public String getDebrisTar() {
        return debrisTar;
    }

    public String getDebrisOil() {
        return debrisOil;
    }

    public String getDebrisOther() {
        return debrisOther;
    }

    public String getDebrisOtherDesc() {
        return debrisOtherDesc;
    }

    public String getDebrisAmount() {
        return debrisAmount;
    }

    public String getNoInWater() {
        return noInWater;
    }

    public String getNumOutOfWater() {
        return numOutOfWater;
    }

    public String getNoPeopleBoating() {
        return noPeopleBoating;
    }

    public String getNoPeopleFishing() {
        return noPeopleFishing;
    }

    public String getNoPeopleSurfing() {
        return noPeopleSurfing;
    }

    public String getNoPeopleWindsurfing() {
        return noPeopleWindsurfing;
    }

    public String getNumPeopleDiving() {
        return numPeopleDiving;
    }

    public String getNoPeopleClamming() {
        return noPeopleClamming;
    }

    public String getNoPeopleOther() {
        return noPeopleOther;
    }

    public String getNoPeopleOtherDesc() {
        return noPeopleOtherDesc;
    }

    public String getAirTemp() {
        return airTemp;
    }

    public String getAirUnits() {
        return airUnits;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getWindSpeedUnits() {
        return windSpeedUnits;
    }

    public String getWindDirDegrees() {
        return windDirDegrees;
    }

    public String getWindDirDesc() {
        return windDirDesc;
    }

    public String getWeatherDes() {
        return weatherDes;
    }

    public String getRainfallLastEvent() {
        return rainfallLastEvent;
    }

    public String getRainfall() {
        return rainfall;
    }

    public String getRainfallUnits() {
        return rainfallUnits;
    }

    public String getRainfallStdDesc() {
        return rainfallStdDesc;
    }

    public String getWaveHeight() {
        return waveHeight;
    }

    public String getWaveHeightUnits() {
        return waveHeightUnits;
    }

    public String getEstActFlag() {
        return estActFlag;
    }

    public String getWaveDirection() {
        return waveDirection;
    }

    public String getWaveConditions() {
        return waveConditions;
    }

    public String getCurrentSpeed() {
        return currentSpeed;
    }

    public String getLongshoreCurrentUnits() {
        return longshoreCurrentUnits;
    }

    public String getShorelineCurrentDir() {
        return shorelineCurrentDir;
    }

    public String getpH() {
        return pH;
    }

    public String getColorChange() {
        return colorChange;
    }

    public String getColorDescription() {
        return colorDescription;
    }

    public String getOdorDescription() {
        return odorDescription;
    }

    public String getOdorOtherDescription() {
        return odorOtherDescription;
    }

    public String getAvgWaterTemp() {
        return avgWaterTemp;
    }

    public String getAvgWaterTempUnits() {
        return avgWaterTempUnits;
    }

    public String getClarityDesc() {
        return clarityDesc;
    }

    public String getNTU() {
        return NTU;
    }

    public String getSecchiTubeCm() {
        return secchiTubeCm;
    }

    public String getAlgaeNearshore() {
        return algaeNearshore;
    }

    public String getAlgaeOnBeach() {
        return algaeOnBeach;
    }

    public String getAlgaeTypePeriphyton() {
        return algaeTypePeriphyton;
    }

    public String getAlgaeTypeGlobular() {
        return algaeTypeGlobular;
    }

    public String getAlgaeTypeFreefloating() {
        return algaeTypeFreefloating;
    }

    public String getAlgaeTypeOther() {
        return algaeTypeOther;
    }

    public String getAlgaeTypeOtherDesc() {
        return algaeTypeOtherDesc;
    }

    public String getAlgaeColorLtGreen() {
        return algaeColorLtGreen;
    }

    public String getAlgaeColorBrightGreen() {
        return algaeColorBrightGreen;
    }

    public String getAlgaeColorDrkGreen() {
        return algaeColorDrkGreen;
    }

    public String getAlgaeColorYellow() {
        return algaeColorYellow;
    }

    public String getAlgaeColorBrown() {
        return algaeColorBrown;
    }

    public String getAlgaeColorOther() {
        return algaeColorOther;
    }

    public String getAlgaeColorOtherDesc() {
        return algaeColorOtherDesc;
    }

    public String getPart1Comments() {
        return part1Comments;
    }

    public String getPart2Comments() {
        return part2Comments;
    }

    public String getPart3Comments() {
        return part3Comments;
    }

    public String getPart4Comments() {
        return part4Comments;
    }

    public LocalDateTime getDateEntered() {
        return dateEntered;
    }

    public LocalDateTime getDateUpdated() {
        return dateUpdated;
    }

    public String getMissingRequiredFlag() {
        return missingRequiredFlag;
    }

    public String getvPages() {
        return vPages;
    }

    public String getSubmitted() {
        return submitted;
    }

    public String getIdNo() {
        return idNo;
    }

    public LocalDateTime getDate() {
        return date;
    }




}
