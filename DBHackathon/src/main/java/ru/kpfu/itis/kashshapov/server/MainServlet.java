package ru.kpfu.itis.kashshapov.server;

import ru.kpfu.itis.kashshapov.dao.SensorDao;
import ru.kpfu.itis.kashshapov.dto.SensorDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/info")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = getDataFromDatabase();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(data);
    }

    private String getDataFromDatabase() {
        SensorDao sensorDao = new SensorDao();
        List<SensorDto> sensors = sensorDao.getAll();
        String name = "";
        String timestamp = "";
        String value = "";
        String isEnabled = "";
        String installationDate = "";

        String info = "[";

        //...получение данных
        for (SensorDto sensorDto : sensors) {
            name = sensorDto.getName();
            timestamp = sensorDto.getTimestamp().toString();
            value = sensorDto.getValue();
            isEnabled = sensorDto.getEnabled().toString();
            installationDate = sensorDto.getInstallationDate().toString();
            info = info + "{\"name\": \"" + name + "\", " +
                    "\"timestamp\": \"" + timestamp + "\", " +
                    "\"value\": \"" + value + "\", " +
                    "\"isEnabled\": \"" + isEnabled + "\", " +
                    "\"installationDate\": \"" + installationDate + "\"}, ";
        }
        return info.substring(0, info.length() - 2) + "]";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
