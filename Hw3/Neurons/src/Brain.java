package vilia002.hw3.neurons;

import java.util.ArrayList;

/**
 * Describes a brain.
 * 
 * A brain is a set of connected {@link Neuron neurons}.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 02/04/2023
 */
public class Brain {
	private ArrayList<Neuron> neurons;
	
	/**
	 * Class constructor.
	 */
	public Brain() {	
		neurons = new ArrayList<Neuron>();
	}
	
	/**
	 * Gets the number of {@link Neuron neurons} in the brain.
	 * 
	 * @return  the number of neurons in the brain
	 */
	public int getNbNeurons() {
		return neurons.size();		
	}
	
	/**
	 * Gets the {@link Neuron} at specified index.
	 * 
	 * @param index  the index of the neuron to get
	 * @return		 the neuron at specified index
	 */
	public Neuron getNeuron(int index) {
		return neurons.get(index);
	}
	
	/**
	 * Adds a new {@link Neuron} with specified characteristics.
	 * 
	 * @param pos		   the position of the neuron to add
	 * @param attenuation  the attenuation of the neuron to add
	 */
	public void addNeuron(Position pos, double attenuation) {
		neurons.add(new Neuron(pos, attenuation));
	}
	
	/**
	 * Adds a new {@link CumulativeNeuron} with specified characteristics.
	 * 
	 * @param pos		   the position of the cumulative neuron to add
	 * @param attenuation  the attenuation of the cumulative neuron to add
	 */
	public void addCumulativeNeuron(Position pos, double attenuation) {
		neurons.add(new CumulativeNeuron(pos, attenuation));
	}
	
	/**
	 * Stimulates the {@link Neuron} at specified index with specified stimulus.
	 * 
	 * @param index     the index of the neuron to stimulate
	 * @param stimulus  the amount of stimulation
	 */
	public void stimulate(int index, double stimulus) {
		neurons.get(index).receivesStimulus(stimulus);
	}
	
	/**
	 * Gets the signal of the {@link Neuron} at specified index.
	 * 
	 * @param index  the index of the neuron
	 * @return		 the signal of the neuron
	 */
	public double probe(int index) {
		return neurons.get(index).getSignal();
	}
	
	/**
	 * Creates connections between {@link Neuron neurons}.
	 */
	public void createConections() {
		if (neurons.size() >= 2)
			neurons.get(0).connection(neurons.get(1));
		
		if (neurons.size() >= 3)
			neurons.get(0).connection(neurons.get(2));
		
		if (neurons.size() >= 4)
			for (int i = 1; i < neurons.size() - 2; i += 2) {
				neurons.get(i).connection(neurons.get(i + 1));
				neurons.get(i + 1).connection(neurons.get(i + 2));
			}
	}
	
	/**
	 * Returns information about all the {@link Neuron neurons} in the brain in string form.
	 * 	 
	 * @return  information about all the {@link Neuron neurons} in the brain in string form
	 */
	public String toString() {
		String str = "The brain contains " + neurons.size() + " neuron(s)\n";
		
		for (Neuron n : neurons)
			str += n.toString() + "\n";
		
		str += "\n*----------*\n\n";
		
		return str;		
	}	
}
