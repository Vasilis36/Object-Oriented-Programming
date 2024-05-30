package vilia002.hw3.neurons;

import java.util.ArrayList;

/**
 * Describes a neuron.
 * 
 * A neuron has a {@link Position}, a signal when stimulated, a specified attenuation
 * and can be connected with other neurons.
 * 
 * @author Vasilis Ilia
 * @version 1.0
 * @since 02/04/2023
 */
public class Neuron {
	private Position position;   
	private double signal;      //  signal stimulated from brain
	private double attenuation;  
	private ArrayList<Neuron> connections;
	
	/**
	 * Class constructor, specifying {@link Position} and attenuation.
	 * 
	 * @param position     the position of the neuron
	 * @param attenuation  the attenuation of the neuron
	 */
	public Neuron(Position position, double attenuation) {
		signal = 0;
		connections = new ArrayList<Neuron>();
		this.position = position;
		this.attenuation = attenuation;		
	}
	
	/**
	 * Gets the position of the neuron.
	 * 
	 * @return  the position of the neuron
	 */
	public Position getPosition() {
		return position;
	}
	
	/**
	 * Gets the number of the connections of the neuron.
	 * 
	 * @return  the number of connections of the neuron
	 */
	public int getNumberOfConnections() {
		return connections.size();
	}
	
	/**
	 * Gets the connected neuron at specified index.
	 * 
	 * @param index  the index of the connected neuron to get
	 * @return       the connected neuron at specified index
	 */
	public Neuron getConnection(int index) {
		return connections.get(index);
	}
	
	/**
	 * Gets the attenuation of the neuron.
	 * 
	 * @return  the attenuation of the neuron
	 */
	public double getAttenuation() {
		return attenuation;
	}
	
	/**
	 * Gets the signal of the neuron.
	 * 
	 * @return  the signal of the neuron
	 */
	public double getSignal() {
		return signal;
	}
	
	/**
	 * Adds the specified neuron to the connections of the neuron.
	 * 
	 * @param n  the neuron to add to the connections
	 */
	public void connection(Neuron n) {
		connections.add(n);
	}
	
	/**
	 * Stimulates the neuron using specified stimulus.
	 * 
	 * Also stimulates any other connected neurons.
	 * 
	 * @param stimulus  the amount of stimulation
	 */
	public void receivesStimulus(double stimulus) {
		signal = stimulus * attenuation;
		
		for (Neuron n : connections)
			n.receivesStimulus(signal);
	}
	
	/**
	 * Returns information about the neuron and all connected neurons in string form.
	 * 
	 * @return  information about the neuron and all connected neurons in string form
	 */
	public String toString() {
		String str = "The neuron in position " + position + " with attenuation " + attenuation;
		
		if (connections.isEmpty())
			str += " without connection\n";
		
		else {
			str += " in connection with\n";
		
			for (Neuron n : connections)
				str += "  - a neuron in position " + n.position + "\n";
		}		
		return str;
	}	
}
