package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Map;


@RestController
public class RestControllerDemo {

	public List<Show> shows = new ArrayList<>();
	public Map<String, List> quotes = new HashMap<>();
	public List<Movie> movies = new ArrayList<>();

	public void addStuff(){
		Movie movie1 = new Movie(0, "Don't Breath");
		Movie movie2 = new Movie(1, "Free Guy");
		Movie movie3 = new Movie(2, "Venom");

		Show show1 = new Show(3, "The Walking Death");
		Show show2 = new Show(4, "Midnight Texas");
		Show show3 = new Show(5, "Game of Thrones");

		shows.add(show1);
		shows.add(show2);
		shows.add(show3);

		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);

		quotes.put("Don't Breath",Arrays.asList(new Quote("Now you're gonna see what I see.", "Blind Man", "Don't Breath", false), new Quote("She was pregnant with my child.", "Blind Man", "Don't Breath", false)));
        quotes.put("Free Guy",Arrays.asList(new Quote("It's Like Losing My Virginity But In My Mouth.", "Free Guy", "Free Guy", false), new Quote("Ooooh Cappuccino. I Enjoy Saying That. It's Like A Waterfall With Letters.", "Free Guy", "Free Guy", false), new Quote("You've Met God...And He's A D*Ck?", "Free Guy", "Free Guy", true)));
        quotes.put("Venom",Arrays.asList(new Quote("We Are Venom.", "Venom", "Venom", false),new Quote("You Cannot Just Go Around Eating Anybody You Want To.", "Somebody", "Venom", false), new Quote("Have A Nice Life.", "Venom", "Venom", false)));
        quotes.put("The Walking Death",Arrays.asList(new Quote("It's gonna be pee-pee pants city here real soon.", "Rick", "The Walking Death", false), new Quote("People you love, they made you who you are. ", "Michonne", "The Walking Death", false), new Quote("The pain doesn't go away.", "Negan", "The Walking Death", false)));
        quotes.put("Midnight Texas",Arrays.asList(new Quote("There's nothing left to fight for.", "Olivia", "Midnight Texas", false), new Quote("The town I love doesn't exist anymore and I would rather die than live in Patience, Texas.", "Olivia", "Midnight Texas", false)));
        quotes.put("Game of Thrones",Arrays.asList(new Quote("You know nothing Jon Snow.", "Ygritte", "Game of Thrones", false), new Quote("Fear cuts deeper than swords.", "Arya Stark", "Game of Thrones", false)));
	}

	public Quote getQuote(){
		addStuff();

		//choose key
		Random r = new Random();
		Object[] keys = quotes.keySet().toArray();
		Object key = keys[new Random().nextInt(keys.length)];

		//Select random quote to return
		List<Quote> quotes2 = quotes.get(key);
		return quotes2.get(new Random().nextInt(quotes.get(key).size()));

	}

	public Quote getQuoteShow(int id){
		HashMap <String, List> quotesShow = new HashMap<>();

		quotesShow.put("The Walking Death",Arrays.asList(new Quote("It's gonna be pee-pee pants city here real soon.", "Rick", "The Walking Death", false), new Quote("People you love, they made you who you are. ", "Michonne", "The Walking Death", false), new Quote("The pain doesn't go away.", "Negan", "The Walking Death", false)));
        quotesShow.put("Midnight Texas",Arrays.asList(new Quote("There's nothing left to fight for.", "Olivia", "Midnight Texas", false), new Quote("The town I love doesn't exist anymore and I would rather die than live in Patience, Texas.", "Olivia", "Midnight Texas", false)));
        quotesShow.put("Game of Thrones",Arrays.asList(new Quote("You know nothing Jon Snow.", "Ygritte", "Game of Thrones", false), new Quote("Fear cuts deeper than swords.", "Arya Stark", "Game of Thrones", false)));

		if(id == 3){
			List<Quote> frases = quotesShow.get("The Walking Death");
			return frases.get(new Random().nextInt(quotesShow.get("The Walking Death").size()));
		}
		else if(id == 4){
			List<Quote> frases = quotesShow.get("Midnight Texas");
			return frases.get(new Random().nextInt(quotesShow.get("Midnight Texas").size()));
		}
		else{
			List<Quote> frases = quotesShow.get("Game of Thrones");
			return frases.get(new Random().nextInt(quotesShow.get("Game of Thrones").size()));
		}

	}

	public Quote getQuoteMovie(int id){
		HashMap <String, List> quotesMovie = new HashMap<>();

		quotesMovie.put("Don't Breath",Arrays.asList(new Quote("Now you're gonna see what I see.", "Blind Man", "Don't Breath", false), new Quote("She was pregnant with my child.", "Blind Man", "Don't Breath", false)));
        quotesMovie.put("Free Guy",Arrays.asList(new Quote("It's Like Losing My Virginity But In My Mouth.", "Free Guy", "Free Guy", false), new Quote("Ooooh Cappuccino. I Enjoy Saying That. It's Like A Waterfall With Letters.", "Free Guy", "Free Guy", false), new Quote("You've Met God...And He's A D*Ck?", "Free Guy", "Free Guy", true)));
        quotesMovie.put("Venom",Arrays.asList(new Quote("We Are Venom.", "Venom", "Venom", false),new Quote("You Cannot Just Go Around Eating Anybody You Want To.", "Somebody", "Venom", false), new Quote("Have A Nice Life.", "Venom", "Venom", false)));

		if(id == 0){
			List<Quote> frases = quotesMovie.get("Don't Breath");
			return frases.get(new Random().nextInt(quotesMovie.get("Don't Breath").size()));
		}
		else if(id == 1){
			List<Quote> frases = quotesMovie.get("Free Guy");
			return frases.get(new Random().nextInt(quotesMovie.get("Free Guy").size()));
		}
		else{
			List<Quote> frases = quotesMovie.get("Venom");
			return frases.get(new Random().nextInt(quotesMovie.get("Venom").size()));
		}

	}

	@GetMapping("/quote")
	public Quote quote() {
		return getQuote();
	}

	@GetMapping("/shows")
	public List show() {
		addStuff();
		return shows;
	}

	@GetMapping("/quotes")
	public Quote quoteFromShowMovie(@RequestParam(value = "show", defaultValue = "0") int id){
		addStuff();

		if (id >= 3){
			return getQuoteShow(id);
		}

		else {
			return getQuoteMovie(id);
        
		}
	}

}