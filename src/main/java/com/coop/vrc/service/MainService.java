package com.coop.vrc.service;

import com.coop.vrc.model.dto.request.VehicleRequest;
import com.coop.vrc.model.dto.response.VehicleResponse;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.coop.vrc.model.constant.Constant.DummyData.*;

@Service
public class MainService {

    private static final Random RANDOM = new Random();

    private final Map<String, VehicleResponse> cache = new HashMap<>();

    public VehicleResponse getByKey(String key) {
        return cache.get(key);
    }

    public VehicleResponse getRandomVehicle(VehicleRequest request) {
        String key = getMainInfo(request);

        if (cache.containsKey(key)) {
            return getByKey(key);
        }

        String randomMaker = getRandomMaker();
        VehicleResponse response = new VehicleResponse(
                randomMaker,
                getRandomModelForMaker(randomMaker),
                getRandomYearForMaker(randomMaker),
                getRandomColorForMaker()
        );

        cache.put(key, response);
        return response;
    }

    private String getMainInfo(VehicleRequest request) {
        return request.getPlateLetter1() + "_" + request.getPlateLetter2() + "_" + request.getPlateLetter3() + "_" + request.getPlateNumber() + "_" + request.getRegistrationType();
    }

    private static String getRandomMaker() {
        List<String> makers = new ArrayList<>(VEHICLE_MAKERS.values());
        return makers.get(RANDOM.nextInt(makers.size()));
    }

    private static String getRandomModelForMaker(String maker) {
        List<String> models = new ArrayList<>(VEHICLE_MAKER_MODELS.get(maker));
        return models.get(RANDOM.nextInt(models.size()));
    }

    private static String getRandomYearForMaker(String maker) {
        int[] range = MAKER_MANUFACTURING_YEARS_RANGE.get(maker);
        if (range == null) {
            int randomIndex = RANDOM.nextInt(MANUFACTURING_YEARS.length);
            return String.valueOf(MANUFACTURING_YEARS[randomIndex]);
        }

        int startYear = range[0];
        int endYear = range[1];
        int year = startYear + RANDOM.nextInt(endYear - startYear + 1);

        return String.valueOf(year);
    }

    private static String getRandomColorForMaker() {
        List<String> colors = new ArrayList<>(VEHICLE_COLORS.values());
        return colors.get(RANDOM.nextInt(colors.size()));
    }
}
