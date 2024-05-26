package org.mtransit.parser.us_washington_state_ferry;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mtransit.commons.CleanUtils;
import org.mtransit.parser.DefaultAgencyTools;
import org.mtransit.parser.MTLog;
import org.mtransit.parser.gtfs.data.GRoute;
import org.mtransit.parser.mt.data.MAgency;

import java.util.List;
import java.util.Locale;

// https://business.wsdot.wa.gov/Transit/csv_files/wsf/google_transit.zip
public class WashingtonStateFerryAgencyTools extends DefaultAgencyTools {

	public static void main(@NotNull String[] args) {
		new WashingtonStateFerryAgencyTools().start(args);
	}

	@Nullable
	@Override
	public List<Locale> getSupportedLanguages() {
		return LANG_EN;
	}

	@Override
	public boolean defaultExcludeEnabled() {
		return true;
	}

	@NotNull
	@Override
	public String getAgencyName() {
		return "WSF";
	}

	@NotNull
	@Override
	public Integer getAgencyRouteType() {
		return MAgency.ROUTE_TYPE_FERRY;
	}

	@Override
	public boolean defaultRouteIdEnabled() {
		return true;
	}

	@Override
	public boolean useRouteShortNameForRouteId() {
		return false; // no route short name provided
	}

	private static final String SEP = "-";

	private static final String ANACORTES_RSN = "Ana";
	private static final String BAINBRIDGE_ISLAND_RSN = "Bai";
	private static final String BREMERTON_RSN = "Bre";
	private static final String CLINTON_RSN = "Cli";
	private static final String COUPEVILLE_RSN = "Cou"; // "key";
	private static final String EDMONDS_RSN = "Edm";
	private static final String FAUNTLEROY_RSN = "Fau";
	private static final String FRIDAY_HARBOR_RSN = "Fri"; // "fh";
	private static final String KINGSTON_RSN = "Kin"; // "king";
	private static final String LOPEZ_ISLAND_RSN = "Lop";
	private static final String MULKITEO_RSN = "Mul"; // "muk";
	private static final String ORCAS_ISLAND_RSN = "Orc";
	private static final String POINT_DEFIANCE_RSN = "Def"; // "pd";
	private static final String PORT_TOWNSEND_RSN = "Tow"; // "pt";
	private static final String SEATTLE_RSN = "Sea";
	private static final String SHAW_ISLAND_RSN = "Sha";
	private static final String SIDNEY_BC_RSN = "Sid";
	private static final String SOUTHWORTH_RSN = "Sou";
	private static final String TAHLEQUAH_RSN = "Tah"; // "tal";
	private static final String VASHON_ISLAND_RSN = "Vas";

	@NotNull
	@Override
	public String provideMissingRouteShortName(@NotNull GRoute gRoute) {
		//noinspection deprecation
		final int rsn = Integer.parseInt(gRoute.getRouteId());
		switch (rsn) {
		// @formatter:off
		case 37: return BAINBRIDGE_ISLAND_RSN + SEP + SEATTLE_RSN; // Bainbridge Island - Seattle
		case 47: return BREMERTON_RSN + SEP + SEATTLE_RSN; // Bremerton - Seattle
		case 73: return SEATTLE_RSN + SEP + BAINBRIDGE_ISLAND_RSN; // Seattle - Bainbridge Island
		case 74: return SEATTLE_RSN + SEP + BREMERTON_RSN; // Seattle - Bremerton
		case 101: return FRIDAY_HARBOR_RSN + SEP + ANACORTES_RSN; // Friday Harbor - Anacortes
		case 110: return ANACORTES_RSN + SEP + FRIDAY_HARBOR_RSN; // Anacortes - Friday Harbor
		case 113: return ANACORTES_RSN + SEP + LOPEZ_ISLAND_RSN; // Anacortes - Lopez Island
		case 115: return ANACORTES_RSN + SEP + ORCAS_ISLAND_RSN; // Anacortes - Orcas Island
		case 118: return ANACORTES_RSN + SEP + SHAW_ISLAND_RSN; // Anacortes - Shaw Island
		case 119: return ANACORTES_RSN + SEP + SIDNEY_BC_RSN ; // Anacortes - Sidney B.C.
		case 128: return KINGSTON_RSN + SEP + EDMONDS_RSN; // Kingston - Edmonds
		case 131: return LOPEZ_ISLAND_RSN + SEP + ANACORTES_RSN; // Lopez Island - Anacortes
		case 145: return MULKITEO_RSN + SEP + CLINTON_RSN; // Mukilteo - Clinton
		case 151: return ORCAS_ISLAND_RSN + SEP + ANACORTES_RSN; // Orcas Island - Anacortes
		case 181: return SHAW_ISLAND_RSN + SEP + ANACORTES_RSN; // Shaw Island - Anacortes
		case 191: return SIDNEY_BC_RSN + SEP + ANACORTES_RSN; // Sidney B.C. - Anacortes
		case 209: return SOUTHWORTH_RSN + SEP + FAUNTLEROY_RSN; // Southworth - Fauntleroy
		case 229: return VASHON_ISLAND_RSN + SEP + FAUNTLEROY_RSN; // Vashon Island - Fauntleroy
		case 514: return CLINTON_RSN + SEP + MULKITEO_RSN; // Clinton - Mukilteo
		case 812: return EDMONDS_RSN + SEP + KINGSTON_RSN; // Edmonds - Kingston
		case 920: return FAUNTLEROY_RSN + SEP + SOUTHWORTH_RSN; // Fauntleroy - Southworth
		case 922: return FAUNTLEROY_RSN + SEP + VASHON_ISLAND_RSN; // Fauntleroy - Vashon Island
		case 1013: return FRIDAY_HARBOR_RSN + SEP + LOPEZ_ISLAND_RSN; // Friday Harbor - Lopez Island
		case 1015: return FRIDAY_HARBOR_RSN + SEP + ORCAS_ISLAND_RSN; // Friday Harbor - Orcas Island
		case 1018: return FRIDAY_HARBOR_RSN + SEP + SHAW_ISLAND_RSN; // Friday Harbor - Shaw Island
		case 1019: return FRIDAY_HARBOR_RSN + SEP + SIDNEY_BC_RSN; // Friday Harbor - Sidney B.C.
		case 1117: return COUPEVILLE_RSN + SEP + PORT_TOWNSEND_RSN; // Coupeville - Port Townsend
		case 1310: return LOPEZ_ISLAND_RSN + SEP + FRIDAY_HARBOR_RSN; // Lopez Island - Friday Harbor
		case 1315: return LOPEZ_ISLAND_RSN + SEP + ORCAS_ISLAND_RSN; // Lopez Island - Orcas Island
		case 1318: return LOPEZ_ISLAND_RSN + SEP + SHAW_ISLAND_RSN; // Lopez Island - Shaw Island
		case 1510: return ORCAS_ISLAND_RSN + SEP + FRIDAY_HARBOR_RSN; // Orcas Island - Friday Harbor
		case 1513: return ORCAS_ISLAND_RSN + SEP + LOPEZ_ISLAND_RSN; // Orcas Island - Lopez Island
		case 1518: return ORCAS_ISLAND_RSN + SEP + SHAW_ISLAND_RSN; // Orcas Island - Shaw Island
		case 1621: return POINT_DEFIANCE_RSN + SEP + TAHLEQUAH_RSN; // Point Defiance - Tahlequah
		case 1711: return PORT_TOWNSEND_RSN + SEP + COUPEVILLE_RSN; // Port Townsend - Coupeville
		case 1810: return SHAW_ISLAND_RSN + SEP + FRIDAY_HARBOR_RSN; // Shaw Island - Friday Harbor
		case 1813: return SHAW_ISLAND_RSN + SEP + LOPEZ_ISLAND_RSN; // Shaw Island - Lopez Island
		case 1815: return SHAW_ISLAND_RSN + SEP + ORCAS_ISLAND_RSN; // Shaw Island - Orcas Island
		case 1910: return SIDNEY_BC_RSN + SEP + FRIDAY_HARBOR_RSN; // Sidney B.C. - Friday Harbor'
		case 2022: return SOUTHWORTH_RSN + SEP + VASHON_ISLAND_RSN; // Southworth - Vashon Island
		case 2116: return TAHLEQUAH_RSN + SEP + POINT_DEFIANCE_RSN; // Tahlequah - Point Defiance
		case 2220: return VASHON_ISLAND_RSN + SEP + SOUTHWORTH_RSN; // Vashon Island - Southworth
		// @formatter:on
		}
		throw new MTLog.Fatal("Unexpected route short name %s!", gRoute);
	}

	@Override
	public boolean defaultRouteLongNameEnabled() {
		return true;
	}

	@Override
	public boolean defaultAgencyColorEnabled() {
		return true;
	}

	private static final String AGENCY_COLOR_GREEN = "007B63"; // GREEN (from logo SVG)

	private static final String AGENCY_COLOR = AGENCY_COLOR_GREEN;

	@NotNull
	@Override
	public String getAgencyColor() {
		return AGENCY_COLOR;
	}

	@Override
	public boolean directionFinderEnabled() {
		return true; // direction_id NOT provided
	}

	@NotNull
	@Override
	public String cleanTripHeadsign(@NotNull String tripHeadsign) {
		tripHeadsign = CleanUtils.keepToAndRemoveVia(tripHeadsign);
		tripHeadsign = CleanUtils.cleanSlashes(tripHeadsign);
		tripHeadsign = CleanUtils.CLEAN_AT.matcher(tripHeadsign).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		tripHeadsign = CleanUtils.CLEAN_AND.matcher(tripHeadsign).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		tripHeadsign = CleanUtils.cleanNumbers(tripHeadsign);
		tripHeadsign = CleanUtils.cleanStreetTypes(tripHeadsign);
		return CleanUtils.cleanLabel(tripHeadsign);
	}

	@NotNull
	@Override
	public String cleanStopName(@NotNull String gStopName) {
		gStopName = CleanUtils.SAINT.matcher(gStopName).replaceAll(CleanUtils.SAINT_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AND.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AND_REPLACEMENT);
		gStopName = CleanUtils.CLEAN_AT.matcher(gStopName).replaceAll(CleanUtils.CLEAN_AT_REPLACEMENT);
		gStopName = CleanUtils.cleanSlashes(gStopName);
		gStopName = CleanUtils.cleanStreetTypes(gStopName);
		return CleanUtils.cleanLabel(gStopName);
	}
}
