package entity.plane;

import enums.ClassificationPlaneLevel;
import enums.ExperimentalPlaneType;

public class ExperimentalPlane extends Plane{

    private ExperimentalPlaneType experimentalPlaneType;
    private ClassificationPlaneLevel classificationPlaneLevel;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity,
                             ExperimentalPlaneType experimentalPlaneType,
                             ClassificationPlaneLevel classificationPlaneLevel) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalPlaneType = experimentalPlaneType;
        this.classificationPlaneLevel = classificationPlaneLevel;
    }

    public ExperimentalPlaneType getExperimentalPlaneType() {
        return experimentalPlaneType;
    }

    public void setExperimentalPlaneType(ExperimentalPlaneType experimentalPlaneType) {
        this.experimentalPlaneType = experimentalPlaneType;
    }

    public ClassificationPlaneLevel getClassificationPlaneLevel() {
        return classificationPlaneLevel;
    }

    public void setClassificationPlaneLevel(ClassificationPlaneLevel classificationPlaneLevel) {
        this.classificationPlaneLevel = classificationPlaneLevel;
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "model='" + getModel() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
