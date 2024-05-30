package vilia002.hw3.neurons;

/**
 * A cumulative neuron is a type of {@link Neuron}.
 * 
 * A cumulative neuron responds to stimulus in an additive way.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 02/04/2023
 */
public class CumulativeNeuron extends Neuron{
	/**
	 * Class constructor, specifying {@link Position} and attenuation.
	 * 
	 * @param position     the position of the neuron
	 * @param attenuation  the attenuation of the neuron
	 */
	public CumulativeNeuron(Position position, double attenuation) {
		super(position, attenuation);
	}

	/**
	 * Stimulates the neuron using specified stimulus.
	 * 
	 * Adds to any previous stimulations. Also stimulates any other connected neurons.
	 * 
	 * @param stimulus  the amount of stimulation
	 */
	public void receivesStimulus(double stimulus) {
		double newSignal = getSignal() + stimulus * getAttenuation();
		super.receivesStimulus(newSignal / getAttenuation());
	}
}
